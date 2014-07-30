<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	style="position: relative; -webkit-transition: right 0.25s ease-in-out; transition: right 0.25s ease-in-out; right: 0px;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lead</title>
<link rel="stylesheet" type="text/css" href="/~core/css/style.css" media="screen" />

</head>
<body id="" class="">
	<div id="container">
		<div id="main">
			<div class="bx-center">
				<ul class="posts">
					<li class="post text login">
						<div class="post-head clearfix">
							<h1>Submit Info</h1>
						</div>
						<p>
						
					    <div id="msg" class="msg"></div>
						<form class="form" id="leadForm" method="post" onsubmit="return false;">
							<p>First Name <input type="text" id="fname" class="reg-input txt" /></p>
							<p>Last Name <input type="text" id="lname" class="reg-input txt" /></p>
							<p>Email<input type="text" id="email" class="reg-input txt" /></p>
							<p>Street  <input type="text" id="street" class="reg-input txt" /></p>
							<p>City <input type="text" id="city" class="reg-input txt" /></p>
							<p>State <input type="text" id="state" class="reg-input txt" /></p>
							<p>Zip <input type="text" id="zip" class="reg-input txt" /></p>
							<p>VIN<input type="text" id="vin" class="reg-input txt" value="2G1FB1E35F9104567"/></p>
							<div class="reg-button right">
								<input type="button"  id="lead-btn" name="lead" value="Submit Lead"/>
							</div>
							<br/>
							<div id="debug" class="debug"></div>
						</form>
					</li>
				</ul>
			</div>

		</div>
	</div>
<script type="text/javascript" src="/~core/js/frmk/jquery.js"></script>
<script type="text/javascript" src="/~core/js/frmk/validate.min.js"></script>
<script type="text/javascript" src="/~core/js/frmk/bootstrap.min.js"></script>
<script type="text/javascript" src="/~core/js/util.js"></script>
<script type="text/javascript" src="/~core/js/rest.js"></script>
<script type="text/javascript" src="/~core/js/bot/lead.js"></script>
</body>
</html>