import React from 'react';
import {signup, changeLanguage} from "../api/apiCalls";
import Input from '../components/input';
import { withTranslation } from "react-i18next"
import ButtonWithProgress from '../components/ButtonWithProgress';
import { withApiProgress } from '../shared/ApiProgress';


class UserSignupPage extends React.Component{

    state = {
        username:null,
        displayName:null,
        password:null,
        passwordRepeat:null,
        errors: {}
    };

    onChange = event => {
        const {t} = this.props;
        const {name , value} = event.target;
        const errors = {... this.state.errors}
        errors[name] = undefined;
        if(name == "password" || name == "passwordRepeat"){
            if(name == "password" && value != this.state.passwordRepeat){
                errors.passwordRepeat = t("Password miss match");
            }
            else if (name == "passwordRepeat" && value != this.state.password){
                errors.passwordRepeat = t("Password miss match");
            }
            else{
                errors.passwordRepeat = undefined;
            }
        }
        this.setState({
            [name]:value,
            errors
        });
    };

    onClickSignUp = async event => {
        event.preventDefault();
        const {username: username,displayName,password} = this.state;
        const body = {
            username,
            displayName,
            password
        };
        
        try {
            const response = await signup(body);
        }
        catch(error){
            this.setState({errors:error.response.data.validationErrors});
        }
    } 



    render(){
        const {errors} = this.state;
        const { username, displayName ,password, passwordRepeat} = errors;
        const {t,pendingApiCall} = this.props;

        return(
            <div className="container">
                <form>
                <h1 className='text-center'>{t("Sign Up")}</h1>
                <Input name = "userName" label = {t("Username")} error={username} onChange={
                    this.onChange
                } ></Input>

                <Input name = "displayName" label = {t("Display name")} error={displayName} onChange={
                    this.onChange
                } ></Input>

                <Input type="password" name = "password" label = {t("Password")} error={password} onChange={
                    this.onChange
                } ></Input>

                <Input name="passwordRepeat"  label={t("Password Repeat")} error = {passwordRepeat} onChange={this.onChange} type="password"></Input>

                <br></br>
                
                <div className='text-center'>
                    <ButtonWithProgress onClick={this.onClickSignUp} disabled = {pendingApiCall || passwordRepeat !== undefined} pendingAPICall ={pendingApiCall}
                    text = {t("Sign Up")}>
                    </ButtonWithProgress>
                </div>

            </form>
            </div>
           
        );
    }
}

const UserSignupPageTranslation = withTranslation()(UserSignupPage);
const UserSignUpPageWithApiProgress = withApiProgress(UserSignupPageTranslation,"/api/1.0/users");
export default UserSignUpPageWithApiProgress;