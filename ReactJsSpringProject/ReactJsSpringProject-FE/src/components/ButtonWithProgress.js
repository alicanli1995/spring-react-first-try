import react from "react";

const ButtonWithProgress = (props) => {
    const {onClick , pendingAPICall , disabled , text} = props;
    return(
        <div>

        <button disabled={disabled} className='btn btn-primary' onClick={onClick}>{pendingAPICall && <span className="spinner-border spinner-border-sm"></span>}
             {text}
        </button>

        </div>
    );
};

export default ButtonWithProgress;