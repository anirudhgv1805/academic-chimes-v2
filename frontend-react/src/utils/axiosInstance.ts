import axios from 'axios';
import { useAuth } from '../context/AuthContext';
import { useEffect } from 'react';

// Create a default Axios instance
export const axiosInstance = axios.create({
    baseURL: import.meta.env.VITE_API_URL,  // Base URL from the environment variable
    headers: {
        'Content-Type': 'application/json',
    },
});

// A custom hook to use the JWT token dynamically in Axios requests
export const useAxiosInstance = () => {
    const { jwtToken } = useAuth();  // Use context to get the token

    useEffect(() => {
        // Setting up request interceptor to attach JWT token to headers
        const requestInterceptor = axiosInstance.interceptors.request.use(
            (config) => {
                if (jwtToken) {
                    config.headers['Authorization'] = `Bearer ${jwtToken}`;  // Attach the token to the Authorization header
                }
                return config;
            },
            (error) => Promise.reject(error)
        );

        // Setting up response interceptor for global error handling (like 401 Unauthorized)
        const responseInterceptor = axiosInstance.interceptors.response.use(
            (response) => response,
            (error) => {
                if (error.response?.status === 401) {
                    console.log('Unauthorized access, redirecting to login...');
                    window.location.href = '/login';  // Redirect to login page on 401
                }
                return Promise.reject(error);
            }
        );

        // Cleanup interceptors when the component unmounts
        return () => {
            axiosInstance.interceptors.request.eject(requestInterceptor);
            axiosInstance.interceptors.response.eject(responseInterceptor);
        };
    }, [jwtToken]);  // Depend on jwtToken, will trigger the effect if the token changes

    return axiosInstance;
};
