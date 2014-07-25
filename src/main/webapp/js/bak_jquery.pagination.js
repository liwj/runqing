/**
 * This jQuery plugin displays pagination links inside the selected elements.
 *
 * @author Gabriel Birke (birke *at* d-scribe *dot* de)
 * @version 1.2
 * @param {int} maxentries Number of entries to paginate
 * @param {Object} opts Several options (see README for documentation)
 * @return {Object} jQuery Object
 */
jQuery.fn.pagination = function(maxentries, opts){
	opts = jQuery.extend({
		items_per_page:pageSize,
		num_display_entries:6,
		current_page:0,
		num_edge_entries:0,
		link_to:"#",
		//prev_text:"上一页",
		//next_text:"下一页",
		ellipse_text:"...",
		prev_img:"prev",
		next_img:"next",
		prev_show_always:true,
		next_show_always:true,
		callback:function(){return false;}
	},opts||{});
	
	return this.each(function() {
		/**
		 * Calculate the maximum number of pages
		 */
		function numPages() {
			return Math.ceil(maxentries/opts.items_per_page);
		}
		
		/**
		 * Calculate start and end point of pagination links depending on 
		 * current_page and num_display_entries.
		 * @return {Array}
		 */
		function getInterval()  {
			var ne_half = Math.ceil(opts.num_display_entries/2);
			var np = numPages();
			var upper_limit = np-opts.num_display_entries;
			var start = current_page>ne_half?Math.max(Math.min(current_page-ne_half, upper_limit), 0):0;
			var end = current_page>ne_half?Math.min(current_page+ne_half, np):Math.min(opts.num_display_entries, np);
			return [start,end];
		}
		
		/**
		 * This is the event handling function for the pagination links. 
		 * @param {int} page_id The new page number
		 */
		function pageSelected(page_id, evt){
			current_page = page_id;
			drawLinks();
			var continuePropagation = opts.callback(page_id, panel);
			if (!continuePropagation) {
				if (evt.stopPropagation) {
					evt.stopPropagation();
				}
				else {
					evt.cancelBubble = true;
				}
			}
			return continuePropagation;
		}
		
		/**
		 * This function inserts the pagination links into the container element
		 */
		function drawLinks() {
			panel.empty();
			var interval = getInterval();
			var np = numPages();
			// This helper function returns a handler function that calls pageSelected with the right page_id
			var getClickHandler = function(page_id) {
				return function(evt){ return pageSelected(page_id,evt); }
			}
			var pre =  jQuery("<a><span class=\'pageimg\'><img src='"+contextPath +"/images/first.gif' width='37' height='15' /></span></a>")
			.bind("click", getClickHandler(0))
			.attr('href', opts.link_to.replace(/__id__/,0));
			panel.append(pre);
			// Helper function for generating a single link (or a span tag if it's the current page)
			var appendItem = function(page_id, appendopts){
				if(page_id == -1 || page_id == np){
					var lnk = jQuery("<a style='display:none'><span><swan>"+(appendopts.text)+"</swan></span></a>");
				}else{
					page_id = page_id<0?0:(page_id<np?page_id:np-1); // Normalize page id to sane value
					appendopts = jQuery.extend({text:page_id+1, classes:""}, appendopts||{});
					if(page_id == current_page){
						var lnk = jQuery("<a><span><swan class='current'>"+(appendopts.text)+"</swan></span></a>");
					}
					else
					{
						var lnk = jQuery("<a flag='"+appendopts.text+"'><span><swan>"+(appendopts.text)+"</swan></span></a>")
							.bind("click", getClickHandler(page_id))
							.attr('href', opts.link_to.replace(/__id__/,page_id));
					}
				}
			
				if(appendopts.classes){lnk.addClass(appendopts.classes);}
				panel.append(lnk);
			}
			// Generate "Previous"-Link
			
		/*	if(opts.prev_text && (current_page > 0 || opts.prev_show_always)){
				appendItem(current_page-1,{text:opts.prev_text});
			}*/
			if(opts.prev_img && (current_page > 0 || opts.prev_show_always)){
				var pageN = current_page-1 <= -1?0:current_page-1;
				var prev =  jQuery("<a><span class=\'pageimg\'><img src='"+contextPath +"/images/back.gif' width=\"43\" height=\"15\" /></span></a>")
				.bind("click", getClickHandler(pageN) )
				.attr('href', opts.link_to.replace(/__id__/,pageN));
				panel.append(prev);
			}
			// Generate starting points
			if (interval[0] > 0 && opts.num_edge_entries > 0)
			{
				var end = Math.min(opts.num_edge_entries, interval[0]);
				for(var i=0; i<end; i++) {
					appendItem(i);
				}
				if(opts.num_edge_entries < interval[0] && opts.ellipse_text)
				{
					jQuery("<swan>"+opts.ellipse_text+"</swan>").appendTo(panel);
				}
			}
			// Generate interval links
			for(var i=interval[0]; i<interval[1]; i++) {
				appendItem(i);
			}
			// Generate ending points
			if (interval[1] < np && opts.num_edge_entries > 0)
			{
				if(np-opts.num_edge_entries > interval[1]&& opts.ellipse_text)
				{
					jQuery("<swan>"+opts.ellipse_text+"</swan>").appendTo(panel);
				}
				var begin = Math.max(np-opts.num_edge_entries, interval[1]);
				for(var i=begin; i<np; i++) {
					appendItem(i);
				}
				
			}
			// Generate "Next"-Link
			/*if(opts.next_text && (current_page < np-1 || opts.next_show_always)){
				appendItem(current_page+1,{text:opts.next_text});
			}*/
			if(opts.next_img && (current_page > 0 || opts.prev_show_always)){
				var pageN = current_page+1 >= np-1? np-1:current_page+1;
				var next =  jQuery("<a><span class=\'pageimg\'><img src='"+contextPath +"/images/next.gif' width=\"43\" height=\"15\" /></span></a>")
				.bind("click", getClickHandler(pageN))
				.attr('href', opts.link_to.replace(/__id__/,pageN));
				panel.append(next);
			}
			
			var last =  jQuery("<a><span class=\'pageimg\'><img src='"+contextPath +"/images/last.gif' width='37' height='15'/></span></a>")
			.bind("click", getClickHandler(np-1 ))
			.attr('href', opts.link_to.replace(/__id__/,np-1 ));			panel.append(last);
			panel.append("<span class=\"STYLE1\"> 第"+(parseInt(current_page)+1)+"页/共"+np+"页 </span> ");
			panel.append("<span class=\"STYLE1\">转到第" +
					"<input name=\"textfield\" id=\"goVal\"  value=\""+(parseInt(current_page)+1)+"\" type=\"text\" size=\"4\" style=\"height:12px; width:20px; border:1px solid #999999;\" /> "
                    +" 页 </span>");
			panel.append("<img src='"+contextPath +"/images/go.gif' width='37' height='15' id=\"go\"/>");
			$("#go").click(function(){
				var reg = /^[0-9]*[0-9][0-9]*$/;
				var val = 1;
				if(reg.test($.trim($("#goVal").val()))){
					val = parseInt($.trim($("#goVal").val()));
				}
				if(val < 1){
					val = 1;
				}else if (val > np){
					val = np;
				}
				opts.current_page = val;
				drawLinks();
				var a = jQuery("<a>"+val+"</a>").bind('click',function(event){
					pageSelected(val-1, event);
				});
				a.attr('href', opts.link_to.replace(/__id__/,val));
				a.click();
			});
		
		}
		
		// Extract current_page from options
		var current_page = parseInt(opts.current_page);
		// Create a sane value for maxentries and items_per_page
		maxentries = (!maxentries || maxentries < 0)?1:maxentries;
		opts.items_per_page = (!opts.items_per_page || opts.items_per_page < 0)?1:opts.items_per_page;
		// Store DOM element for easy access from all inner functions
		var panel = jQuery(this);
		// Attach control functions to the DOM element 
		this.selectPage = function(page_id){ pageSelected(page_id);}
		this.prevPage = function(){ 
			if (current_page > 0) {
				pageSelected(current_page - 1);
				return true;
			}
			else {
				return false;
			}
		}
		this.nextPage = function(){ 
			if(current_page < numPages()-1) {
				pageSelected(current_page+1);
				return true;
			}
			else {
				return false;
			}
		}
		// When all initialisation is done, draw the links
		drawLinks();
        // call callback function
        opts.callback(current_page, this);
	});
}


