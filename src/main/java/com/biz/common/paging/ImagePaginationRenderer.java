package com.biz.common.paging;

public class ImagePaginationRenderer extends AbstractPaginationRenderer {

	public ImagePaginationRenderer() {
		String strWebDir = "/resources/img/paging/";
		
		firstPageLabel = "<a href=\"#\" onclick=\"{0}({1}); return false;\">" +
			"<image src='" + strWebDir + "btn_page_pre10.gif' border=0/></a>&#160;"; 
		previousPageLabel = "<a href=\"#\" onclick=\"{0}({1}); return false;\">" +
						"<image src='" + strWebDir + "btn_page_pre1.gif' border=0/></a>&#160;";
		currentPageLabel = "<strong>{0}</strong>&#160;";
		otherPageLabel = "<a href=\"#\" onclick=\"{0}({1}); return false;\">{2}</a>&#160;";
		nextPageLabel = "<a href=\"#\" onclick=\"{0}({1}); return false;\">" +
					"<image src='" + strWebDir + "btn_page_next1.gif' border=0/></a>&#160;";
		lastPageLabel = "<a href=\"#\" onclick=\"{0}({1}); return false;\">" +
					"<image src='" + strWebDir + "btn_page_next10.gif' border=0/></a>&#160;";
		
	}

	@Override
	public String renderPagination(PaginationInfo paginationInfo, String jsFunction) {
		return super.renderPagination(paginationInfo, jsFunction);
	}

}
