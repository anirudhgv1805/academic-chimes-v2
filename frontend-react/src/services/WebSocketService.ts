import { Client, StompSubscription } from "@stomp/stompjs";
import { SocketMessage } from "../types/SocketMessage";

class WebSocketService{
    private client : Client;
    private connectPromise:Promise<void> | null = null;

    private reconnectDelay:number = 3000;
    private maxReconnectAttempts:number = 5;
    private reconnectAttempts:number = 0;
    private heartBeatIncoming:number = 1000;
    private heartBeatOutgoing:number = 1000;
    
    constructor(private token: string) {
        this.client = new Client({
            brokerURL: import.meta.env.VITE_WEBSOCKET_URL,
            connectHeaders:{
                Authorization:`Bearer ${this.token}`,
            },
            heartbeatIncoming:this.heartBeatIncoming,
            heartbeatOutgoing:this.heartBeatOutgoing,
            debug:(msg)=>this.debug(msg),
            reconnectDelay:this.reconnectDelay,
            // onConnect:(frame)=>this.onConnect(frame),
        });

        this.client.onConnect = (frame) => {
            console.log("onConnect"+frame)
        }

        this.client.onDisconnect = (frame) => {
            console.log("onDisconnect"+frame)
        }

        this.client.onStompError = (e) => {
            console.error("Stomp Error"+e);
        }

        this.client.onWebSocketError = (e) => {
            console.error("Websocket Error"+e);
        }

    }
    debug(msg: string): void {
        console.log("debug error : "+msg);
    }

    connect(): Promise<void> {
        if(!this.connectPromise) {
            this.connectPromise = new Promise((resolve,reject) => {
                this.client.activate();
                this.client.onConnect = () =>{
                    console.log("Connected to Websocket");
                    resolve();
                };
                this.client.onStompError = (frame) => {
                    console.error("STOMP error",frame);
                    reject(new Error('Failed to establish the connection to the WebSocket'));
                };
                this.client.onWebSocketError = (e) => {
                    console.error('WebSocket Error',e);
                    reject(new Error('WebSocket error'));
                };
            });
        }
        return this.connectPromise;
    }

    disconnect() {
        if (this.client.active){
            this.client.deactivate();
        }
        this.connectPromise = null;
    }

    async subscribe<T>( destination : string , callback : (message:SocketMessage<T>) => void ) : Promise<StompSubscription | undefined>{
        try {
            await this.connect();
            return this.client.subscribe(destination, (message) => {
                const parsedMessage = JSON.parse(message.body) as SocketMessage<T>;
                callback(parsedMessage);
            });
        } catch(err:unknown){
            console.log("An error at subscribe : "+err);
        }
    }

    async send<T> (destination:string,message:SocketMessage<T>){
        try {
            await this.connect();
            this.client.publish({
                destination,
                body: JSON.stringify(message),
            });
        } catch (err : unknown) {
            console.error("Failed to send the message ",err);
        }
    }

}

export default WebSocketService;