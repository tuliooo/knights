package Dominio;


public enum Raza {
	  HUMANO {
	      public String toString() {
	          return "HUMANO";
	      }
	  },

	  ELFO {
	      public String toString() {
	          return "ELFO";
	      }
	  },
	  ENANO {
	      public String toString() {
	          return "ENANO";
	      }
	  },
	  ORCO {
	      public String toString() {
	          return "ORCO";
	      }
	  }
}