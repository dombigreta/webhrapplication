const JobPage = React.createClass({
   getInitialState:function(){
       return { Jobs:[],
                Currencies:[],
                Locations:[],
                Careers:[],
                SelectedCurrency:'',
                SelectedLocation:'',
                SelectedCareer:''};
   },
    init:function(){
       var self = this;
      $.ajax({url:'/jobs'}).then(jobs => self.setState({Jobs:jobs}));
      $.ajax({url:'/jobs/currencies'}).then(currencies => self.setState({Currencies:currencies}));
      $.ajax({url:'/jobs/locations'}).then(locations => self.setState({Locations: locations}));
      $.ajax({url:'/jobs/careers'}).then(careers => self.setState({Careers: careers}));
    },
    handleChange:function(e, property){
       var self = this;
       self.setState({[property]: e.target.value});
    },
    filterJobs: function() {
        var self = this;
        var {SelectedCurrency, SelectedLocation, SelectedCareer} = self.state;
        var baseUrl = 'jobs/filterJobs?';

        var currencyUrlParam = SelectedCurrency.trim().length > 0 ? `currency=${SelectedCurrency}` : '';
        var locationUrlParam = SelectedLocation.trim().length > 0 ? `location=${SelectedLocation}`: '';
        var careerUrlParam = SelectedCareer.trim().length > 0 ? `carrer=${SelectedCareer}` : '';
        $.ajax(baseUrl + currencyUrlParam + '&&' + locationUrlParam + '&&'+ careerUrlParam)
            .then(filteredJobs => self.setState({Jobs:filteredJobs}));
   },

    componentDidMount(){
       this.init();
    },
    render:function(){
       return(
           <div className="content-holder mt-4">
               <div className="d-flex">
                    <div className="col-4 d-flex align-items-center">
                        <span className="mr-4">Currencies</span>
                       <select value={this.state.SelectedCurrency}  onChange={(e) => this.handleChange(e, 'SelectedCurrency')} className="form-control form-control-sm">
                           <option  value="">Select none</option>
                           {this.state.Currencies.map((x,i)=> <option key={i} value={x}>{x}</option>)}
                       </select>
                    </div>
                   <div className="col-4 d-flex align-items-center">
                       <span className="mr-4">Locations</span>
                       <select value={this.state.SelectedLocation} onChange={(e) => this.handleChange(e, 'SelectedLocation')} className="form-control form-control-sm">
                           <option  value="">Select none</option>
                           {this.state.Locations.map((x,i) => <option key={i} value={x}>{x}</option>)}
                       </select>
                   </div>
                   <div className="col-4 d-flex align-items-center">
                       <span className="mr-4">Career bands</span>
                       <select value={this.state.SelectedCareer} onChange={(e) => this.handleChange(e, 'SelectedCareer')} className="form-control form-control-sm">
                                <option  value="">Select none</option>
                           {this.state.Careers.map((x,i) => <option key={i} value={x}>{x}</option>)}
                       </select>
                   </div>

                   <button onClick={this.filterJobs} className="btn btn-primary">Filter Jobs</button>
               </div>
           <div className="table mt-4">
           <div className="d-flex table-header">
               <div className="col text-center">Name</div>
               <div className="col text-center">Description</div>
               <div className="col text-center">NumberOfApplicants</div>
               <div className="col text-center">NumberOfFreePlaces</div>
               <div className="col text-center">Payment</div>
               <div className="col text-center">Currency</div>
               <div className="col text-center">CareerType</div>
               <div className="col text-center">Location</div>
           </div>
           <div>{this.state.Jobs.map(x =>
               <div className="d-flex table-content">
                   <div className="col text-center">{x.name}</div>
                   <div className="col text-center">{x.description}</div>
                   <div className="col text-center">{x.numberOfApplicants}</div>
                   <div className="col text-center">{x.numberOfFreePlaces}</div>
                   <div className="col text-center">{x.payment}</div>
                   <div className="col text-center">{x.currency}</div>
                   <div className="col text-center">{x.careerType}</div>
                   <div className="col text-center">{x.location}</div>
               </div>)}</div>
       </div>
           </div>);
   }
});