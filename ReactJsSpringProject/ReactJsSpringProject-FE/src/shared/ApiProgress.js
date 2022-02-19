import React, { Component } from 'react'
import axios from 'axios';

function getDisplayName(WrappedComponent){
    return WrappedComponent.displayName || WrappedComponent.name || "Component";
}

export function withApiProgress(WrappedComponent, appPath){
    return class extends Component {

        static displayName = "ApiProgress(" + getDisplayName(WrappedComponent); 

        state = {
            pendingApiCall:false
        };
        
        componentDidMount(){
            this.requestIncepter = axios.interceptors.request.use((request) => {
                console.log("running " , appPath);
                this.updateApiCallFor(request.url,true);
                return request;
            })
            this.responseIncepter = axios.interceptors.response.use((response) => {
                this.updateApiCallFor(response.config.url,false);
                return response;  
            }, (error) => {
                this.updateApiCallFor(error.config.url,false);
                throw error;
            });
        }
        

        componentWillUnmount(){
            axios.interceptors.request.eject(this.requestIncepter);
            axios.interceptors.request.eject(this.responseIncepter);
        }

        updateApiCallFor = (url, inProgress) =>{
            if(url === appPath){
                this.setState({pendingApiCall:inProgress});
            }
        }
    
        render() {
            const {pendingApiCall } = this.state;
            return <WrappedComponent pendingApiCall={pendingApiCall} {... this.props}/>
        }
    }
}



