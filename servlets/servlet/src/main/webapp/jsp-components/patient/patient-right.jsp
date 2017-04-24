<div class="right_col" role="main">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">

            <div class="x_title">
                <h2>Patient <small>Profile</small></h2>
                <div class="clearfix"></div>
            </div>

            <div class="x_content">

                <div class="col-md-3 col-sm-3 col-xs-12 profile_left">
                    <div class="profile_img">
                        <div id="crop-avatar">
                            <!-- Current avatar -->
                            <img class="img-responsive avatar-view" src="images/picture.jpg" alt="Avatar" title="Change the avatar">
                        </div>
                    </div>

                    <h3>${user.name()}</h3>
                    <ul class="list-unstyled user_data">
                        <li><i class="fa fa-male user-profile-icon"></i> ${user.gender()}</li>
                        <li>Age: ${user.age()}</li>
                        <li><i class="fa fa-map-marker user-profile-icon"></i> ${user.address()}</li>
                        <li>DNI: ${user.dni()}</li>
                        <li>Assigned Doctor: -</li>
                    </ul>

                </div>

                <div class="col-md-9 col-sm-9 col-xs-12">

                    <div class="profile_title">
                        <div class="col-md-6">
                            <h2>User Activity Report</h2>
                        </div>
                        <div class="col-md-6">
                            <div id="reportrange" class="pull-right" style="margin-top: 5px; background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #E6E9ED">
                                <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                                <span>March 4, 2017 - April 2, 2017</span> <b class="caret"></b>
                            </div>
                        </div>
                    </div>

                    <!-- start of user-activity-graph -->
                    <jsp:include page="patient-graph.jsp"/>
                    <!-- end of user-activity-graph -->

                    <div class="" role="tabpanel" data-example-id="togglable-tabs">
                        <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                            <li role="presentation" class="active"><a href="#tab_content1" role="tab" id="profile-tab" data-toggle="tab" aria-expanded="true">Samples history</a>
                            </li>
                            <li role="presentation" class=""><a href="#tab_content2" id="home-tab" role="tab" data-toggle="tab" aria-expanded="false">Questions</a>
                            </li>
                        </ul>
                        <div id="myTabContent" class="tab-content">
                            <div role="tabpanel" class="tab-pane fade active in" id="tab_content1" aria-labelledby="profile-tab">

                                <!-- start user projects -->
                                <jsp:include page="patient-samples-history.jsp"/>
                                <!-- end user projects -->

                            </div>
                            <div role="tabpanel" class="tab-pane fade" id="tab_content2" aria-labelledby="home-tab">

                                <!-- start recent activity -->
                                <jsp:include page="patient-questions.jsp"/>
                                <!-- end recent activity -->

                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

</div>