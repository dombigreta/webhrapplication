const ApplicantPage = React.createClass({
    getInitialState:function(){
        return {Applicants:[]}
    },
    loadApplicants:function(){
        var self = this;
        $.ajax({url:'/applicants'})
          .then(applicants => self.setState({Applicants: applicants}));

    },
    componentDidMount(){
        this.loadApplicants();
    },
    render: function () {
        return (
            <div className="content-holder mt-4">
            <div className=" table">
                <div className="d-flex table-header">
                    <div className="col text-center">First name</div>
                    <div className="col text-center">Middle name</div>
                    <div className="col text-center">Last name</div>
                    <div className="col text-center">Gender</div>
                    <div className="col text-center">Education</div>
                    <div className="col text-center">Address</div>
                    <div className="col text-center">Age</div>
                </div>
            <div>{this.state.Applicants.map(x =>
            <div className="d-flex table-content">
            <div className="col text-center">{x.firstName}</div>
                <div className="col text-center">{(x.middleName == null || x.middleName.trim().length == 0) ? '-' : x.middleName }</div>
                <div className="col text-center">{x.lastName}</div>
                <div className="col text-center">{x.gender}</div>
                <div className="col text-center">{x.education}</div>
                <div className="col text-center">{x.address}</div>
                <div className="col text-center">{x.age}</div>
            </div>)}</div>
        </div>
            </div>
        )
    }
});