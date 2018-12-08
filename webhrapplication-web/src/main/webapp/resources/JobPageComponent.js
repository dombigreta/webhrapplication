const JobPage = React.createClass({
   getInitialState:function(){
       return {Jobs:[]};
   },
    loadJobs:function(){
       var self = this;
      $.ajax({url:'/jobs'}).then(jobs => self.setState({Jobs:jobs}));
    },
    componentDidMount(){
       this.loadJobs();
    },
    render:function(){
       return(
           <div className="content-holder mt-4">
               <div className="d-flex">
                   <div>

                       <select className="form-control form-control-sm">
                           <option>Small select</option>
                       </select>
                </div>
               <select className="form-control form-control-sm">
                   <option>Small select</option>
               </select>

               <select className="form-control form-control-sm">
                   <option>Small select</option>
               </select>
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