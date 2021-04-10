package com.app.entity;

import java.util.ArrayList;
import java.util.List;

	public class Documents
	{
	    private List<Document> documentList;
	    
	    public List<Document> getDocumentList() {
	        if(documentList == null) {
	        	documentList = new ArrayList<>();
	        }
	        return documentList;
	    }
	 
	    public void setDocumentList(List<Document> documentList) {
	        this.documentList = documentList;
	    }
	}