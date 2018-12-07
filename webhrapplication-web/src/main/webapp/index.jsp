<!DOCTYPE html>
<html>
<head>
    <title>webhr-application</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style type="text/css">
        <%@ include file="resources/main.css" %>
    </style>
</head>
<body>
<div id='root'></div>

<script src="https://fb.me/react-15.0.1.js"></script>
<script src="https://fb.me/react-dom-15.0.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>


<script type="text/babel">
    var MainPage = React.createClass({

        loadData:function(){
            var self = this;
            $.ajax({url:'/applicants'}).then(function(data){
                console.log(data);
            })
        },
        componentDidMount:function(){
            this.loadData();
        },
        handleClick(urlaction){
            alert(urlaction);
        },

        render: function() {
            var links = [{displayName:'Home', urlName:''},{displayName:'Applicants', urlName:'applicants'},{displayName:'Jobs', urlName:'jobs'}];


            return (
                <div>
                    <nav className="d-flex navigation-bar mb-4">
                        {links.map((link,i) => <div  key={i}><a className="mr-2 navigation-link" onClick={() => this.handleClick(link.urlName)}>{link.displayName}</a></div>)}
                    </nav>
                    <div className="content-holder">
                        <div className="content-box">
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi eleifend feugiat enim volutpat placerat.
                            Proin accumsan augue et odio elementum, id cursus nisl malesuada. Ut euismod ipsum eget ullamcorper viverra.
                            Curabitur sed elit nec erat mollis tristique. Donec ut enim a dolor pulvinar cursus at vitae nulla. Cras tempus,
                            ligula vel faucibus euismod, sem tortor porta dolor, vel tincidunt ligula est ac orci. Ut ante eros, tincidunt eu
                            ante in, dapibus eleifend ligula. Proin id tristique sem. Quisque faucibus facilisis ante eu finibus. Quisque sed
                            dapibus sem. Cras id ornare eros, sit amet ullamcorper elit. Mauris eu magna sed elit pretium molestie. Fusce vel
                            turpis justo. Proin vitae laoreet quam. Pellentesque malesuada lacus tortor, tristique tempor leo pharetra ut.
                        </div>
                        <div className="content-box">
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi eleifend feugiat enim volutpat placerat.
                            Proin accumsan augue et odio elementum, id cursus nisl malesuada. Ut euismod ipsum eget ullamcorper viverra.
                            Curabitur sed elit nec erat mollis tristique. Donec ut enim a dolor pulvinar cursus at vitae nulla. Cras tempus,
                            ligula vel faucibus euismod, sem tortor porta dolor, vel tincidunt ligula est ac orci. Ut ante eros, tincidunt eu
                            ante in, dapibus eleifend ligula. Proin id tristique sem. Quisque faucibus facilisis ante eu finibus. Quisque sed
                            dapibus sem. Cras id ornare eros, sit amet ullamcorper elit. Mauris eu magna sed elit pretium molestie. Fusce vel
                            turpis justo. Proin vitae laoreet quam. Pellentesque malesuada lacus tortor, tristique tempor leo pharetra ut.
                        </div>
                        <div className="content-box">
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi eleifend feugiat enim volutpat placerat.
                            Proin accumsan augue et odio elementum, id cursus nisl malesuada. Ut euismod ipsum eget ullamcorper viverra.
                            Curabitur sed elit nec erat mollis tristique. Donec ut enim a dolor pulvinar cursus at vitae nulla. Cras tempus,
                            ligula vel faucibus euismod, sem tortor porta dolor, vel tincidunt ligula est ac orci. Ut ante eros, tincidunt eu
                            ante in, dapibus eleifend ligula. Proin id tristique sem. Quisque faucibus facilisis ante eu finibus. Quisque sed
                            dapibus sem. Cras id ornare eros, sit amet ullamcorper elit. Mauris eu magna sed elit pretium molestie. Fusce vel
                            turpis justo. Proin vitae laoreet quam. Pellentesque malesuada lacus tortor, tristique tempor leo pharetra ut.
                        </div>

                    </div>
                </div>);
        }
    });

    ReactDOM.render(
        <MainPage />, document.getElementById('root')
    );
</script>
</body>
</html>