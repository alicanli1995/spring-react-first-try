import React from 'react';
import Input from '../components/input';
import { withTranslation } from "react-i18next"
import {login} from "../api/apiCalls"
import ButtonWithProgress from '../components/ButtonWithProgress';
import { withApiProgress } from '../shared/ApiProgress';
import {Authentication} from "../shared/AuthenticationContext";

class UserLoginPage extends React.Component{
    static contextType = Authentication;

    state = {
        username:null,
        password:null,
        error:null,
        
    };


    onChange = event => {
        const {name , value} = event.target;
        this.setState({
            [name]:value,
            error:null
        });
    };


    onClickLogin = async event =>{
        event.preventDefault();
        const {username , password} = this.state;
        const {onLoginSuccess} = this.context;
        const creds = {
            username,
            password
        }
        const { push } = this.props.history;
        this.setState({
            error:null
        })
        try{
            const response = await login(creds);
            
            push("/");
            const authState = {
                ...response.data,
                password:password
            };
            onLoginSuccess(authState);
        }
        catch(apiError){
            this.setState({
                error:apiError.response.data.message 
            })
        }
    };

    render(){
        const {t,pendingApiCall} = this.props;
        const {error,username,password} = this.state;
        const buttonEnabled = username && password;


        return (
            <div className="container">
                <form>
                <h1 className='text-center'>{t("Login")}</h1>
                <Input name = "username" label = {t("Username")}  onChange={this.onChange} ></Input>

                <Input type="password" name ="password" label = {t("Password")}  onChange={this.onChange} ></Input>
                <br></br>
                {error && <div className='alert alert-danger' role = "alert">
                        {error}
                </div>}

                <br></br>

                <div className='text-center'>
                <ButtonWithProgress onClick={this.onClickLogin} disabled={!buttonEnabled || pendingApiCall} pendingAPICall ={pendingApiCall}
                text = {t("Login")}>
                </ButtonWithProgress>
                 </div>

            </form>
            </div>
        );
    }

}

const LoginWithTranslation = withTranslation()(UserLoginPage);

export default withApiProgress(LoginWithTranslation , "/api/1.0/auth");