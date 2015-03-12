<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link type="text/css" rel="stylesheet" href="resources/css/ADV02.css" />
<script type="text/javascript" src="resources/js/ADV02.js"></script>
<s:form action="ADV02_confirm">
	<div class="container">
		<div class="row">
			<br/><br/>
			<div class="">
				<%-- <div class="pull-left">
					<s:a href="ADV01_init" cssClass="btn btn-default btn-xs" style="width:100px">
						<span class="glyphicon glyphicon-th-list"></span> List App
					</s:a>
				</div> --%>
				<div class="pull-right">
					<%-- <s:submit cssClass="btn btn-default btn-xs" style="width:100px">
						<span class="glyphicon glyphicon-save"></span> Confirm
					</s:submit> --%>
					<button type="submit" class="btn btn-default btn-xs" style="width:100px">
						<span class="glyphicon glyphicon-save"></span> Save
					</button>
				</div>
			</div>
			<div class="panel filterable">
				<br/><br/>
				<table class="table table-condensed table-bordered">
	    		<caption align="top">
	    			<s:if test="%{msgError != null}">
						<p class="text-left text-danger">
							<s:label name="msgError" />
						</p>
					</s:if>
					<s:if test="%{info.message != null}">
						<p class="text-left text-success">
							<s:label name="info.message" />
						</p>
					</s:if>
	    		</caption>
	    		<tbody>
	    			<s:if test="%{listAdnetwork != null && listAdnetwork.size > 0}">
	    				<s:iterator value="listAdnetwork" status="listAdnetworkStatus" var="adnetwork">
	    					<s:if test="%{#adnetwork.adnetworkName == 'admob'}">
	    						<tr style="background-color: #d3d3d3">
	    							<td class="info" style="width: 150px;">
	    								<s:property value="%{#adnetwork.adnetworkName}"/>
	    								<s:hidden name="listAdnetwork[%{#listAdnetworkStatus.index}].adnetworkName" value="%{#adnetwork.adnetworkName}"/>
	    							</td>
	    							<td>
	    								<%-- <s:property value="%{#adnetwork.perForAdmob}"/> --%>
	    								<s:textfield name="listAdnetwork[%{#listAdnetworkStatus.index}].perForAdmob" value="%{#adnetwork.perForAdmob}"/>
	    							</td>
	    						</tr>
	    					</s:if>
	    					<s:else>
	    				<tr style="background-color: #d3d3d3">
	    					<td class="info" style="width: 150px;">
	    						<s:property value="%{#adnetwork.adnetworkName}"/>
	    						<s:hidden name="listAdnetwork[%{#listAdnetworkStatus.index}].adnetworkName" value="%{#adnetwork.adnetworkName}"/>
	    						<s:set var="adNetIndex" value="%{#listAdnetworkStatus.index}"/>
	    					</td>
	    					<td>
	    						<div class="span12">
						    		<div class="menu">
						                <div class="accordion">
						            		<div class="accordion-group">
						            			<div class="accordion-heading country">
						            				<a class="accordion-toggle" data-toggle="collapse" href="#banner_${adNetIndex}">Banner</a>
						            			</div>
						            			<div id="banner_${adNetIndex}" class="accordion-body collapse">
						            				<div class="accordion-inner">
						            					<table class="table table-condensed table-bordered" id="tblBanner_${adNetIndex}">
						            						<thead>
						            							<tr style="background-color:#F7E7CE">
						            								<th style="text-align: center">ID</th>
						            								<th style="text-align: center">Image</th>
						            								<th style="text-align: center">Android</th>
						            								<th style="text-align: center">Ios</th>
						            								<th style="text-align: center">Windows Phone</th>
						            								<th style="text-align: center">Delete</th>
						            							</tr>
						            						</thead>   
						            						<tbody id="bodyBanner_${adNetIndex}">
						            							<s:if test="%{#adnetwork.listAdsBanner != null && #adnetwork.listAdsBanner.size > 0}">
						            								<s:iterator value="#adnetwork.listAdsBanner" status="listAdsBannerStatus" var="adsBanner">
						            									<tr>
						            										<td style="vertical-align: middle;">
						            											<s:property value="%{#adsBanner.id}"/>
						            											<s:hidden name="listAdnetwork[%{#listAdnetworkStatus.index}].listAdsBanner[%{#listAdsBannerStatus.index}].id" value="%{#adsBanner.id}" cssClass="adId"/>
						            										</td>
						            										
						            										<td style="vertical-align: middle;text-align: center">
						            											<s:if test="%{#adsBanner.urlImage != null && #adsBanner.urlImage != ''}">
						            												<img width="40px" height="50px" src="<s:url value="%{#adsBanner.urlImage}"/>">
						            												<s:hidden name="listAdnetwork[%{#listAdnetworkStatus.index}].listAdsBanner[%{#listAdsBannerStatus.index}].urlImage" value="%{#adsBanner.urlImage}" cssClass="adImg"/>
						            											</s:if>
						            										</td>
						            										<td style="vertical-align: middle;text-align: center">
						            											<s:textfield name="listAdnetwork[%{#listAdnetworkStatus.index}].listAdsBanner[%{#listAdsBannerStatus.index}].perAndroid" value="%{#adsBanner.perAndroid}" cssClass="adAndroid"/>
						            										</td>
						            										<td style="vertical-align: middle;text-align: center">
						            											<s:textfield name="listAdnetwork[%{#listAdnetworkStatus.index}].listAdsBanner[%{#listAdsBannerStatus.index}].perIos" value="%{#adsBanner.perIos}" cssClass="adIos"/>
						            										</td>
						            										<td style="vertical-align: middle;text-align: center">
						            											<s:textfield name="listAdnetwork[%{#listAdnetworkStatus.index}].listAdsBanner[%{#listAdsBannerStatus.index}].perWindow" value="%{#adsBanner.perWindow}" cssClass="adWin"/>
						            										</td>
						            										<s:set var="bannerIdx" value="%{#listAdsBannerStatus.index}"/>
						            										<td style="vertical-align: middle;text-align: center">
						            											<button type="button" class="btn btn-default btn-xs btnDel" name="${adNetIndex}_Banner_${bannerIdx}">
																					<span class="glyphicon glyphicon-remove"></span> Del
																				</button>
						            										</td>
						            									</tr>
						            								</s:iterator>
						            							</s:if>
						            						</tbody>
						            					</table>
						            				</div>
						            				<button type="button" id="" class="btn btn-default btn-xs addBanner" style="width: 100px;" name="${adNetIndex}">
														<span class="glyphicon glyphicon-plus"></span> Add
													</button>
					            				</div>
					            				<div class="accordion-heading country">
						            				<a class="accordion-toggle" data-toggle="collapse" href="#popup_${adNetIndex}">Popup</a>
						            			</div>
						            			<div id="popup_${adNetIndex}" class="accordion-body collapse">
						            				<div class="accordion-inner">
						            					<table class="table table-condensed table-bordered">
						            						<thead>
						            							<tr style="background-color:#F7E7CE">
						            								<th style="text-align: center">ID</th>
						            								<th style="text-align: center">Image</th>
						            								<th style="text-align: center">Android</th>
						            								<th style="text-align: center">Ios</th>
						            								<th style="text-align: center">Windows Phone</th>
						            								<th style="text-align: center">Delete</th>
						            							</tr>
						            						</thead>   
						            						<tbody id="bodyPopup_${adNetIndex}">
						            							<s:if test="%{#adnetwork.listAdsPopup != null && #adnetwork.listAdsPopup.size > 0}">
						            								<s:iterator value="#adnetwork.listAdsPopup" status="listAdsPopupStatus" var="adsPopup">
						            									<tr>
						            										<td style="vertical-align: middle;">
						            											<s:property value="%{#adsPopup.id}"/>
						            											<s:hidden name="listAdnetwork[%{#listAdnetworkStatus.index}].listAdsPopup[%{#listAdsPopupStatus.index}].id" value="%{#adsPopup.id}" cssClass="adId"/>
						            										</td>
						            										
						            										<td style="vertical-align: middle;text-align: center">
						            											<s:if test="%{#adsPopup.urlImage != null && #adsPopup.urlImage != ''}">
						            												<img width="40px" height="50px" src="<s:url value="%{#adsPopup.urlImage}"/>">
						            												<s:hidden name="listAdnetwork[%{#listAdnetworkStatus.index}].listAdsPopup[%{#listAdsPopupStatus.index}].urlImage" value="%{#adsPopup.urlImage}" cssClass="adImg"/>
						            											</s:if>
						            										</td>
						            										<td style="vertical-align: middle;text-align: center">
						            											<s:textfield name="listAdnetwork[%{#listAdnetworkStatus.index}].listAdsPopup[%{#listAdsPopupStatus.index}].perAndroid" value="%{#adsPopup.perAndroid}" cssClass="adAndroid"/>
						            										</td>
						            										<td style="vertical-align: middle;text-align: center">
						            											<s:textfield name="listAdnetwork[%{#listAdnetworkStatus.index}].listAdsPopup[%{#listAdsPopupStatus.index}].perIos" value="%{#adsPopup.perIos}" cssClass="adIos"/>
						            										</td>
						            										<td style="vertical-align: middle;text-align: center">
						            											<s:textfield name="listAdnetwork[%{#listAdnetworkStatus.index}].listAdsPopup[%{#listAdsPopupStatus.index}].perWindow" value="%{#adsPopup.perWindow}" cssClass="adWin"/>
						            										</td>
						            										<s:set var="popupIdx" value="%{#listAdsPopupStatus.index}"/>
						            										<td style="vertical-align: middle;text-align: center">
						            											<button type="button" class="btn btn-default btn-xs btnDel" name="${adNetIndex}_Popup_${popupIdx}">
																					<span class="glyphicon glyphicon-remove"></span> Del
																				</button>
						            										</td>
						            									</tr>
						            								</s:iterator>
						            							</s:if>
						            						</tbody>
						            					</table>
						            				</div>
						            				<button type="button" class="btn btn-default btn-xs addPopup" name="${adNetIndex}" style="width: 100px;">
														<span class="glyphicon glyphicon-plus"></span> Add
													</button>
					            				</div>
					            				<div class="accordion-heading country">
						            				<a class="accordion-toggle" data-toggle="collapse" href="#app_open_${adNetIndex}">AppOpen</a>
						            			</div>
						            			<div id="app_open_${adNetIndex}" class="accordion-body collapse">
						            				<div class="accordion-inner">
						            					<table class="table table-condensed table-bordered">
						            						<thead>
						            							<tr style="background-color:#F7E7CE">
						            								<th style="text-align: center">ID</th>
						            								<th style="text-align: center">Image</th>
						            								<th style="text-align: center">Android</th>
						            								<th style="text-align: center">Ios</th>
						            								<th style="text-align: center">Windows Phone</th>
						            								<th style="text-align: center">Delete</th>
						            							</tr>
						            						</thead>   
						            						<tbody id="bodyOpen_${adNetIndex}">
						            							<s:if test="%{#adnetwork.listAdsOpen != null && #adnetwork.listAdsOpen.size > 0}">
						            								<s:iterator value="#adnetwork.listAdsOpen" status="listAdsOpenStatus" var="adsOpen">
						            									<tr>
						            										<td style="vertical-align: middle;">
						            											<s:property value="%{#adsOpen.id}"/>
						            											<s:hidden name="listAdnetwork[%{#listAdnetworkStatus.index}].listAdsOpen[%{#listAdsOpenStatus.index}].id" value="%{#adsOpen.id}" cssClass="adId"/>
						            										</td>
						            										
						            										<td style="vertical-align: middle;text-align: center">
						            											<s:if test="%{#adsOpen.urlImage != null && #adsOpen.urlImage != ''}">
						            												<img width="40px" height="50px" src="<s:url value="%{#adsOpen.urlImage}"/>">
						            												<s:hidden name="listAdnetwork[%{#listAdnetworkStatus.index}].listAdsOpen[%{#listAdsOpenStatus.index}].urlImage" value="%{#adsOpen.urlImage}" cssClass="adImg"/>
						            											</s:if>
						            										</td>
						            										<td style="vertical-align: middle;text-align: center">
						            											<s:textfield name="listAdnetwork[%{#listAdnetworkStatus.index}].listAdsOpen[%{#listAdsOpenStatus.index}].perAndroid" value="%{#adsOpen.perAndroid}" cssClass="adAndroid"/>
						            										</td>
						            										<td style="vertical-align: middle;text-align: center">
						            											<s:textfield name="listAdnetwork[%{#listAdnetworkStatus.index}].listAdsOpen[%{#listAdsOpenStatus.index}].perIos" value="%{#adsOpen.perIos}" cssClass="adIos"/>
						            										</td>
						            										<td style="vertical-align: middle;text-align: center">
						            											<s:textfield name="listAdnetwork[%{#listAdnetworkStatus.index}].listAdsOpen[%{#listAdsOpenStatus.index}].perWindow" value="%{#adsOpen.perWindow}" cssClass="adWin"/>
						            										</td>
						            										<s:set var="openIdx" value="%{#listAdsOpenStatus.index}"/>
						            										<td style="vertical-align: middle;text-align: center">
						            											<button type="button" class="btn btn-default btn-xs btnDel" name="${adNetIndex}_Open_${openIdx}">
																					<span class="glyphicon glyphicon-remove"></span> Del
																				</button>
						            										</td>
						            									</tr>
						            								</s:iterator>
						            							</s:if>
						            						</tbody>
						            					</table>
						            				</div>
						            				<button type="button" class="btn btn-default btn-xs addOpen" name="${adNetIndex}" style="width: 100px;">
														<span class="glyphicon glyphicon-plus"></span> Add
													</button>
					            				</div>
					            				<div class="accordion-heading country">
						            				<a class="accordion-toggle" data-toggle="collapse" href="#app_exit_${adNetIndex}">AppExit</a>
						            			</div>
						            			<div id="app_exit_${adNetIndex}" class="accordion-body collapse">
						            				<div class="accordion-inner">
						            					<table class="table table-condensed table-bordered">
						            						<thead>
						            							<tr style="background-color:#F7E7CE">
						            								<th style="text-align: center">ID</th>
						            								<th style="text-align: center">Image</th>
						            								<th style="text-align: center">Android</th>
						            								<th style="text-align: center">Ios</th>
						            								<th style="text-align: center">Windows Phone</th>
						            								<th style="text-align: center">Delete</th>
						            							</tr>
						            						</thead>   
						            						<tbody id="bodyExit_${adNetIndex}">
						            							<s:if test="%{#adnetwork.listAdsExit != null && #adnetwork.listAdsExit.size > 0}">
						            								<s:iterator value="#adnetwork.listAdsExit" status="listAdsExitStatus" var="adsExit">
						            									<tr>
						            										<td style="vertical-align: middle;">
						            											<s:property value="%{#adsExit.id}"/>
						            											<s:hidden name="listAdnetwork[%{#listAdnetworkStatus.index}].listAdsExit[%{#listAdsExitStatus.index}].id" value="%{#adsExit.id}" cssClass="adId"/>
						            										</td>
						            										
						            										<td style="vertical-align: middle;text-align: center">
						            											<s:if test="%{#adsExit.urlImage != null && #adsExit.urlImage != ''}">
						            												<img width="40px" height="50px" src="<s:url value="%{#adsExit.urlImage}"/>">
						            												<s:hidden name="listAdnetwork[%{#listAdnetworkStatus.index}].listAdsExit[%{#listAdsExitStatus.index}].urlImage" value="%{#adsExit.urlImage}" cssClass="adImg"/>
						            											</s:if>
						            										</td>
						            										<td style="vertical-align: middle;text-align: center">
						            											<s:textfield name="listAdnetwork[%{#listAdnetworkStatus.index}].listAdsExit[%{#listAdsExitStatus.index}].perAndroid" value="%{#adsExit.perAndroid}" cssClass="adAndroid"/>
						            										</td>
						            										<td style="vertical-align: middle;text-align: center">
						            											<s:textfield name="listAdnetwork[%{#listAdnetworkStatus.index}].listAdsExit[%{#listAdsExitStatus.index}].perIos" value="%{#adsExit.perIos}" cssClass="adIos"/>
						            										</td>
						            										<td style="vertical-align: middle;text-align: center">
						            											<s:textfield name="listAdnetwork[%{#listAdnetworkStatus.index}].listAdsExit[%{#listAdsExitStatus.index}].perWindow" value="%{#adsExit.perWindow}" cssClass="adWin"/>
						            										</td>
						            										<s:set var="exitIdx" value="%{#listAdsExitStatus.index}"/>
						            										<td style="vertical-align: middle;text-align: center">
						            											<button type="button" class="btn btn-default btn-xs btnDel" name="${adNetIndex}_Exit_${exitIdx}">
																					<span class="glyphicon glyphicon-remove"></span> Del
																				</button>
						            										</td>
						            									</tr>
						            								</s:iterator>
						            							</s:if>
						            						</tbody>
						            					</table>
						            				</div>
						            				<button type="button" class="btn btn-default btn-xs addExit" name="${adNetIndex}" style="width: 100px;">
														<span class="glyphicon glyphicon-plus"></span> Add
													</button>
					            				</div>
						            		</div>
						            	</div>
						            </div>
					            </div>			
	    					</td>
	    				</tr>
	    			</s:else>
	    			</s:iterator>
	    			</s:if>
	    		</tbody>
	    	</table>
			</div>
		</div>
	</div>

		<%-- <s:iterator value="listUser" status="listStatus" var="user">
			<s:textfield name="listUser[%{#listStatus.index}].id" value="%{#user.id}"/>
			<s:textfield name="listUser[%{#listStatus.index}].name" value="%{#user.name}"/>
			<br/><br/>
		</s:iterator>
		
		<s:iterator value="listAds" status="listAdsStatus" var = "ads">
			<s:textfield name="listAds[%{#listAdsStatus.index}].id]" value="%{#ads.id}"/>
			<s:textfield name="listAds[%{#listAdsStatus.index}].name]" value="%{#ads.name}"/>
			<br/><br/>
		</s:iterator>
		<s:iterator value="listParent" status="listParentStatus" var="parent">
			<s:textfield name="listParent[%{#listParentStatus.index}].name" value="%{#parent.name}"/>
			<br><br>
		</s:iterator>
		<s:iterator value="listAdsNetwrok" status ="listStatus" var="adsNet">
			<s:textfield name="listAdsNetwrok[%{#listStatus.index}].adnetworkName" value="%{#adsNet.adnetworkName}"/>
			<s:textfield name="listAdsNetwrok[%{#listStatus.index}].perForAdmob" value="%{#adsNet.perForAdmob}"/>
			<br><br>
		</s:iterator> --%>
</s:form>
