package com.Elastic.search.prop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Index {
	    private String name;
	    private String type;
	    private int from;
	    private int size;
	    private int timeout;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public int getFrom() {
			return from;
		}
		public void setFrom(int from) {
			this.from = from;
		}
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
		public int getTimeout() {
			return timeout;
		}
		public void setTimeout(int timeout) {
			this.timeout = timeout;
		}
	    
	    
}
