import UserSignupPage from '../pages/UserSignupPage';
import UserLoginPage from '../pages/UserLoginPage';
import LanguageSelector from "../components/LanguageSelector";
import ApiProgress from "../shared/ApiProgress";
import '../i18n';
import HomePage from '../pages/HomePage';
import UserPage from '../pages/UserPage';
import {HashRouter as Router, Route , Redirect, Switch} from "react-router-dom";
import TopBar from '../components/TopBar';
import React from 'react';
import { Authentication } from "../shared/AuthenticationContext";

class App extends React.Component {
  static contextType = Authentication;

  render()
  {
    const isLoggedIn = this.context.state.isLoggedIn;

    return (
      <div >
          <Router>
            <TopBar />
              <Switch>
                <Route exact path="/" component={HomePage} />
                {!isLoggedIn  && <Route exact path="/login" component={UserLoginPage} />}
                {!isLoggedIn  && <Route  exact path="/signup" component={UserSignupPage} />}
                <Route exact path="/user/:username" component={UserPage} />
                <Redirect  to="/" />
              </Switch>
          </Router>
        <LanguageSelector />
      </div>
    );
  }
}

export default App;
