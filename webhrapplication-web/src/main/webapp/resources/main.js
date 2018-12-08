var Main = "mainpage";
var Applicant = "applicants";
var Job = "jobpage";

var MainPage = React.createClass({
    getInitialState() {
        return {mainView:Main};
    },

    changeView:function(view){
        var self = this;
        self.setState({mainView: view});
    },
    renderView:function(){
        var self = this;
        switch (self.state.mainView) {
          case Main: return <HomePage/>;
          break;
          case Applicant: return <ApplicantPage/>;
          break;
          case Job: return <JobPage/>;
          break;
          default: return <HomePage/>;
          break;
      }
    },
    render: function() {
        var links = [{displayName:'Home', urlName:Main},{displayName:'Applicants', urlName:Applicant},{displayName:'Jobs', urlName:Job}];

        return (
            <div>
                <nav className="d-flex navigation-bar">
                    {links.map((link,i) => <div  key={i}><a onClick={() => this.changeView(link.urlName)} className="mr-2 navigation-link">{link.displayName}</a></div>)}
                </nav>

                <div>
                    {this.renderView()}
                </div>
                <footer className="main-footer">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi eleifend feugiat enim volutpat
                    placerat.
                </footer>
            </div>);
    }
});

ReactDOM.render(
    <MainPage />, document.getElementById('root')
);