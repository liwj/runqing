<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<#macro head title keywords description>
	<head>
	<title>${title!}</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="${keywords!}" />
	<meta name="description" content="${description!}" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/css/reset.css" media="screen" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/css/text.css" media="screen" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/css/grid.css" media="screen" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/css/layout.css" media="screen" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/css/nav.css" media="screen" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/css/jquery.jqplot.min.css" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/css/my.css" />
	<!--[if IE 6]><link rel="stylesheet" type="text/css" href="css/ie6.css" media="screen" /><![endif]-->
	<!--[if IE 7]><link rel="stylesheet" type="text/css" href="css/ie.css" media="screen" /><![endif]-->
	<#nested>
	</head>
</#macro>
<#macro body>
<body>
    <div class="container_12">
        <div class="grid_12 header-repeat">
            <div id="branding">
                <div class="floatleft">
                    <img src="img/logo.png" alt="Logo" /></div>
                <div class="floatright">
                    <div class="floatleft">
                        <img src="img/img-profile.jpg" alt="Profile Pic" /></div>
                    <div class="floatleft marginleft10">
                        <ul class="inline-ul floatleft">
                            <li>Hello Admin</li>
                            <li><a href="#">自己</a></li>
                            <li><a href="${contextPath}/logout">退出</a></li>
                        </ul>
                        <br />
                        <span class="small grey">Last Login: 3 hours ago</span>
                    </div>
                </div>
                <div class="clear">
                </div>
            </div>
        </div>
        <div class="clear">
        </div>
        <div class="grid_12">
            <ul class="nav main">
                <li class="ic-dashboard"><a href="dashboard.html"><span>Dashboard</span></a> </li>
                <li class="ic-form-style"><a href="javascript:"><span>Controls</span></a>
                    <ul>
                        <li><a href="form-controls.html">Forms</a> </li>
                        <li><a href="buttons.html">Buttons</a> </li>
                        <li><a href="form-controls.html">Full Page Example</a> </li>
                        <li><a href="table.html">Page with Sidebar Example</a> </li>
                    </ul>
                </li>
                <li class="ic-typography"><a href="typography.html"><span>Typography</span></a></li>
				<li class="ic-charts"><a href="charts.html"><span>Charts & Graphs</span></a></li>
                <li class="ic-grid-tables"><a href="table.html"><span>Data Table</span></a></li>
                <li class="ic-gallery dd"><a href="javascript:"><span>Image Galleries</span></a>
               		 <ul>
                        <li><a href="image-gallery.html">Pretty Photo</a> </li>
                        <li><a href="gallery-with-filter.html">Gallery with Filter</a> </li>
                    </ul>
                </li>
                <li class="ic-notifications"><a href="notifications.html"><span>Notifications</span></a></li>

            </ul>
        </div>
        <div class="clear">
        </div>
        <div class="grid_2">
            <div class="box sidemenu">
                <div class="block" id="section-menu">
	                <#if Session.viewSources?? &&  Session.viewSources?size &gt; 0>
                    <ul class="section menu">
	    				<#list viewSources as source>
                        <li><a class="menuitem">${source.sourcename!''}</a>
                            <#if source.sources?? &&  source.sources?size &gt;0> 
                            <ul class="submenu">
                              	<#list source.sources as sour>
                                <li><a href="${contextPath}${sour.sourceurl}">${sour.sourcename}</a> </li>
                                </#list>
                            </ul>
                           	</#if>
                        </li>
                        </#list>
                    </ul>
                    </#if>
                </div>
            </div>
        </div>
        <#nested>
        <div class="clear">
		</div>
		<div class="zhezhangDiv hidden">
			<div class="grid_12" id="showOperInfo">
				
			</div>
			<div class="clear">
			</div>
		</div>
    </div>
    <div class="clear">
    </div>
    <div id="site_info">
        <p>
            Copyright <a href="#">BlueWhale Admin</a>. All Rights Reserved.
        </p>
    </div>
</body>
</#macro>
<#macro script>
	<!-- BEGIN: load jquery -->
	<script language="javascript" type="text/javascript" src="${contextPath}/js/jquery-1.6.4.min.js"></script>
	<script language="javascript" type="text/javascript" src="${contextPath}/js/jquery-ui/jquery.ui.core.min.js"></script>
	<script language="javascript" type="text/javascript" src="${contextPath}/js/jquery-ui/jquery.ui.widget.min.js" ></script>
	<script language="javascript" type="text/javascript" src="${contextPath}/js/jquery-ui/jquery.ui.accordion.min.js"></script>
	<script language="javascript" type="text/javascript" src="${contextPath}/js/jquery-ui/jquery.effects.core.min.js"></script>
	<script language="javascript" type="text/javascript" src="${contextPath}/js/jquery-ui/jquery.effects.slide.min.js"></script>
	<!-- END: load jquery -->
	<!-- BEGIN: load jqplot -->
	<!--[if lt IE 9]><script language="javascript" type="text/javascript" src="js/jqPlot/excanvas.min.js"></script><![endif]-->
	<script language="javascript" type="text/javascript" src="${contextPath}/js/jqPlot/jquery.jqplot.min.js"></script>
	<script language="javascript" type="text/javascript" src="${contextPath}/js/jqPlot/plugins/jqplot.barRenderer.min.js"></script>
	<script language="javascript" type="text/javascript" src="${contextPath}/js/jqPlot/plugins/jqplot.pieRenderer.min.js"></script>
	<script language="javascript" type="text/javascript" src="${contextPath}/js/jqPlot/plugins/jqplot.categoryAxisRenderer.min.js"></script>
	<script language="javascript" type="text/javascript" src="${contextPath}/js/jqPlot/plugins/jqplot.highlighter.min.js"></script>
	<script language="javascript" type="text/javascript" src="${contextPath}/js/jqPlot/plugins/jqplot.pointLabels.min.js"></script>
	<!-- END: load jqplot -->
	<script language="javascript" type="text/javascript" src="${contextPath}/js/setup.js"></script>
	<script type="text/javascript">
	
	    $(document).ready(function () {
	        setupLeftMenu();
			setSidebarHeight();
	    });
	</script>
	<#nested>
</#macro>
</html>
