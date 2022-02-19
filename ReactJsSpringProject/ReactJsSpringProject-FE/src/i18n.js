import i18n from "i18next";
import {initReactI18next} from "react-i18next";

i18n.use(initReactI18next).init({
    resources: {
        en:{
            translations: {
                "Sign Up" : "Sign Up",
                "Password miss match": "Password miss match",
                "Username" : "Username",
                "Display name" : "Display name",
                "Password" : "Password",
                "Password Repeat" : "Password Repeat",
                "Login" : "Login",
                "Logout" : "Logout"
            }
        },
        tr: {
            translations: {
                "Sign Up" :  "Kayıt Ol",
                "Password miss match" : "Aynı şifreyi giriniz.",
                "Username":"Kullanıcı adı",
                "Display name" : "Takma İsim",
                "Password" : "Şifre",
                "Password Repeat" : "Şifreyi Tekrar Giriniz",
                "Login" : "Giriş",
                "Logout" : "Çıkış"

            }
        }
    },
    fallbackLng: "tr",
    ns: ['translations'],
    defaultNS: "translations",
    keySeparator: false,
    interpolation: {
        escapeValue:false,
        formatSeparator:","
    },
    react: {
        wait:true
    }
});

export default i18n;