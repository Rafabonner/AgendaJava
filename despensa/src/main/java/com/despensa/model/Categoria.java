package com.despensa.model;

public class Categoria {

		private int id;
		private String descri_categ;
				
		public Categoria () {
			
		}

		public Categoria(int id, String descri_categ) {
			super();
			this.id = id;
			this.descri_categ = descri_categ;
		}

		public int getId() {
			return id;
		}

		public void setId(int id_categoria) {
			this.id = id_categoria;
		}

		public String getDescri_categ() {
			return descri_categ;
		}

		public void setDescri_categ(String descri_categ) {
			this.descri_categ = descri_categ;
		}

		
		
	
}
