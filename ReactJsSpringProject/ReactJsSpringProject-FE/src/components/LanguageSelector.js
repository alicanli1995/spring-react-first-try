import React from "react";
import { withTranslation } from "react-i18next"
import {changeLanguage} from "../api/apiCalls";

const LanguageSelector = props => {

    const onChangeLanguage = language =>{
        const { i18n } = props;
        i18n.changeLanguage(language);
        changeLanguage(language);
    };

    return (
        <div className="container">
            <img src={require('../img/tr.png')} onClick={() => onChangeLanguage("tr")} style={{cursor:"pointer"}} />
            <img src={require('../img/us.png')} onClick={() => onChangeLanguage("en")} style={{cursor:"pointer"}} />
        </div>
    );
};

export default withTranslation()(LanguageSelector);