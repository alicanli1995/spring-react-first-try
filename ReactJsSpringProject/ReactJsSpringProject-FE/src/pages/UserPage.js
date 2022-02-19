import react from "react";
import { withRouter } from "react-router";
import ProfileCard from "../components/ProfileCard";

const UserPage = (props) => {
    return (
        <div className = "container">
        
        <ProfileCard />
        
        </div>
    );
};

export default (UserPage);