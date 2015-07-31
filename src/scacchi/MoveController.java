package scacchi;

public class MoveController{
	private Casella[][] squares = null;
	boolean turno = true; //iniziano i bianchi
	Casella prima, seconda;
	boolean sottoScacco = false;
	boolean guardaScacco = false;
	
	public MoveController(Casella[][] squares){
		this.squares = squares;
	}
	
	public void onClick(Casella cliccata){
		if (prima == null)
		{ // se siamo al primo clic
			if (cliccata.getPezzo() != null)
			{ // se abbiamo cliccato su una casella che contiene un pezzo
				if (cliccata.getPezzo().getColore() == turno)
				{ // se la casella cliccata contiene un pezzo con colore del turno
					prima = cliccata; // salva la casella cliccata in prima
				}
				else
				{ // se abbiamo cliccato su una casella che contiene un pezzo del colore opposto del turno
					prima = null;
				}
			}
			else
			{ // se abbiamo cliccato su una casella vuota
				prima = null;
			}
		}
		else
		{ // non siamo al primo clic
			if (cliccata.getPezzo() == null)
			{ // se abbiamo cliccato su una casella vuota
				seconda = cliccata;
			}
			else
			{ // se abbiamo cliccato su una casella che contiene un pezzo
				if (cliccata.getPezzo().getColore() != turno)
				{ // se abbiamo cliccato su una casella che contiene un pezzo del colore opposto al turno
					seconda = cliccata;		
				}
				else
				{ // se abbiamo cliccato su una casella che contiene un pezzo dello stesso colore del turno
					prima = null;
				}
			}
		}
		if (seconda != null)
		{
			
			controlloMossa(prima, seconda);
			prima = null;
			seconda = null;
	
		}

	}
	
	private void controlloMossa(Casella prima, Casella seconda){
		int x,y,i,f,j;
		int ii=0, jj=0;
		boolean possibile = true;
		switch (prima.getPezzo().getNome())
		{
		
		case "Pedone":
			if(turno == true){
				
			//PROMOZIONE!!!!!!!!!!!!!!!!!!!!!!!
				
				if(seconda.getPezzo()==null){
					if(prima.getColumn() == seconda.getColumn()){
						if(prima.getRow() == (seconda.getRow() + 1)){
							seconda.setPezzo(prima.getPezzo());
							prima.eliminaPezzo();
							cambiaTurno();
						}
						else 
							break;
					}			
				}
				else{
					if(prima.getColumn() == (seconda.getColumn() +1) || ( prima.getColumn() == (seconda.getColumn() - 1))){
						if(prima.getRow() == (seconda.getRow() + 1)){
							seconda.setPezzo(prima.getPezzo());
							prima.eliminaPezzo();
							cambiaTurno();
						}
						else
							break;
					}
				}
						
			}
			else{
				
				if(seconda.getPezzo()==null){
					if(prima.getColumn() == seconda.getColumn()){
						if(prima.getRow() == (seconda.getRow() - 1)){
							seconda.setPezzo(prima.getPezzo());
							prima.eliminaPezzo();
							cambiaTurno();
						}
					} else
						break;
				}
				else{
					if(prima.getColumn() == (seconda.getColumn() +1) || ( prima.getColumn() == (seconda.getColumn() - 1))){
						if(prima.getRow() == (seconda.getRow() - 1)){
							seconda.setPezzo(prima.getPezzo());
							prima.eliminaPezzo();
							cambiaTurno();
						}
					}
					else
						break;
				}
					
			}
			
			break;
				
			
		case "Torre":

			if(seconda.getRow() == prima.getRow()){
				i = prima.getColumn();
				f = seconda.getColumn();
				x = seconda.getRow();
				if(i > f){
					int temp = f;
					f=i;
					i = temp;
				}
				for(int k = f-1; k > i; k--){
					if(squares[x][k].getPezzo() != null){
						possibile = false;
					}
						
				}
			}
			else if(seconda.getColumn() == prima.getColumn()){
				 i = prima.getRow();
				 f = seconda.getRow();
				 y = seconda.getColumn();
					if(i > f){
						int temp = f;
						f=i;
						i = temp;
					}
					for(int k = f-1; k > i; k--){
						if(squares[k][y].getPezzo() != null){
							possibile = false;
						}
							
					}

			}
			else{
				break;
			}
			if(possibile){
				seconda.setPezzo(prima.getPezzo());
				prima.eliminaPezzo();
				cambiaTurno();
			}
		
		
			
			
			break;
			
			
			
		case "Alfiere":	
			//sinistra
			boolean possibileM=false;
			i = prima.getRow() - 1;
			j = prima.getColumn() - 1;

			while(i>=0 && j >= 0){
				if( i == seconda.getRow() && j == seconda.getColumn()){
						possibile = true;
						ii = -1;
						jj = -1;
				}		
				i--;
				j--;
			}
			if(possibile)
				possibileM = controllaSePassaggioLiberoAlfiere(ii,jj);
			i = prima.getRow() - 1;
			j = prima.getColumn() + 1;
			while(i>=0 && j >= 0){
				if( i == seconda.getRow() && j == seconda.getColumn()){
						possibile = true;
						ii = -1;
						jj = +1;
				}		
				i--;
				j++;
			}
			if(possibile)
				possibileM = controllaSePassaggioLiberoAlfiere(ii,jj);
			
			i = prima.getRow() + 1;
			j = prima.getColumn() + 1;
			while(i>=0 && j >= 0){
				if( i == seconda.getRow() && j == seconda.getColumn()){
						possibile = true;
						ii = +1;
						jj = +1;
				}		
				i++;
				j++;
			}
			if(possibile)
				possibileM =  controllaSePassaggioLiberoAlfiere(ii,jj);
			
			i = prima.getRow() + 1;
			j = prima.getColumn() - 1;
			while(i>=0 && j >= 0){
				if( i == seconda.getRow() && j == seconda.getColumn()){
						possibile = true;
						ii = +1;
						jj = -1;
				}		
				i++;
				j--;
			}
			if(possibile)
				possibileM = controllaSePassaggioLiberoAlfiere(ii,jj);

			
			if(possibileM){
				seconda.setPezzo(prima.getPezzo());
				prima.eliminaPezzo();	
			}
			else
				break;
		
		
			
			cambiaTurno();		
			break;
					
			
		case "Cavallo":	
			possibile = false;
			int diffX = Math.abs(prima.getRow() - seconda.getRow());
			int diffY = Math.abs(prima.getColumn() - seconda.getColumn());
			if((diffX == 2 && diffY == 1) || (diffX == 1 && diffY == 2))
				possibile = true;
			if(possibile){
				seconda.setPezzo(prima.getPezzo());
				prima.eliminaPezzo();	
			}
			else
				break;
			cambiaTurno();		
			break;			
			
			
		case "Regina":
			boolean posM=false;
			//guardo se movimento possibile (come torre e alfiere)
			
			
			//come torre
			if(seconda.getRow() == prima.getRow()){
				i = prima.getColumn();
				f = seconda.getColumn();
				x = seconda.getRow();
				if(i > f){
					int temp = f;
					f=i;
					i = temp;
				}
				for(int k = f-1; k > i; k--){
					if(squares[x][k].getPezzo() != null){
						possibile = false;
					}
						
				}
				if(possibile){
					seconda.setPezzo(prima.getPezzo());
					prima.eliminaPezzo();
					cambiaTurno();
					break;
					
				}
			}
			else if(seconda.getColumn() == prima.getColumn()){
				 i = prima.getRow();
				 f = seconda.getRow();
				 y = seconda.getColumn();
					if(i > f){
						int temp = f;
						f=i;
						i = temp;
					}
					for(int k = f-1; k > i; k--){
						if(squares[k][y].getPezzo() != null){
							possibile = false;
						}
							
					}

					if(possibile){
						seconda.setPezzo(prima.getPezzo());
						prima.eliminaPezzo();
						cambiaTurno();
						break;
						
					}
			}
			
		

			//come Alfiere
				i = prima.getRow() - 1;
				j = prima.getColumn() - 1;
				while(i>=0 && j >= 0){
					if( i == seconda.getRow() && j == seconda.getColumn()){
							possibile = true;
							ii = -1;
							jj = -1;
					}		
					i--;
					j--;
				}
				if(possibile)
					posM = controllaSePassaggioLiberoAlfiere(ii,jj);
				i = prima.getRow() - 1;
				j = prima.getColumn() + 1;
				while(i>=0 && j >= 0){
					if( i == seconda.getRow() && j == seconda.getColumn()){
							possibile = true;
							ii = -1;
							jj = +1;
					}		
					i--;
					j++;
				}
				if(possibile)
					posM = controllaSePassaggioLiberoAlfiere(ii,jj);
				
				i = prima.getRow() + 1;
				j = prima.getColumn() + 1;
				while(i>=0 && j >= 0){
					if( i == seconda.getRow() && j ==seconda.getColumn()){
							possibile = true;
							ii = +1;
							jj = +1;
					}		
					i++;
					j++;
				}
				if(possibile)
					posM = controllaSePassaggioLiberoAlfiere(ii,jj);
				
				i = prima.getRow() + 1;
				j = prima.getColumn() - 1;
				while(i>=0 && j >= 0){
					if( i == seconda.getRow() && j == seconda.getColumn()){
							possibile = true;
							ii = +1;
							jj = -1;
					}		
					i++;
					j--;
				}
				if(possibile)
					posM = controllaSePassaggioLiberoAlfiere(ii,jj);

		
			
			if(posM==true){
				seconda.setPezzo(prima.getPezzo());
				prima.eliminaPezzo();	
			}
			else
				break;
		
		
		
			cambiaTurno();		
			break;
			
			
			
		case "Re":	
			diffX = Math.abs(prima.getRow() - seconda.getRow());
			diffY = Math.abs(prima.getColumn() - seconda.getColumn());
//			if(seconda.getPezzo()==null){ //sposta ma nn mangia
				if(prima.getColumn() == seconda.getColumn()){
					if((prima.getRow() == (seconda.getRow() - 1 )|| (prima.getRow() == (seconda.getRow() + 1)))){
						controlloMangiaRe(seconda);
						if(guardaScacco==false){
							seconda.setPezzo(prima.getPezzo());
							prima.eliminaPezzo();
							
						}
					}
				}
				else if(prima.getRow() == seconda.getRow()){
					if((prima.getColumn() == (seconda.getColumn() - 1 )|| (prima.getColumn() == (seconda.getColumn() + 1)))){
						controlloMangiaRe(seconda);
						if(guardaScacco==false){
							seconda.setPezzo(prima.getPezzo());
							prima.eliminaPezzo();
							
						}
					}	
				}	
				else if( diffX == 1 && diffY == 1 ){
					controlloMangiaRe(seconda);
					if(guardaScacco== false){
						seconda.setPezzo(prima.getPezzo());
						prima.eliminaPezzo();
						
					}
					}
				
					
				
					
//			}
			
			
		
			cambiaTurno();
			break;
				
		}
		
		
		
	}
	//true se mangia
	private void controlloMangiaRe(Casella doveRe){
		
		for(int i=0; i<8; i++){
			for(int j=0; i<8; i++){
				if(squares[i][j].getPezzo() != null && squares[i][j].getPezzo().getColore() != turno){
					mangiaRe(squares[i][j], doveRe);
					if (guardaScacco == true)
						break;
						
				}
			}
		}
		
	}
	//true se venisse mangiato, false se non
	//seconda = doveRE
	private void mangiaRe(Casella prima, Casella seconda){
			int x,y,i,f,j;
			int ii=0, jj=0;
			boolean possibile = true;
			switch (prima.getPezzo().getNome())
			{
			
			case "Pedone":
				if(turno == true){
					
				//PROMOZIONE!!!!!!!!!!!!!!!!!!!!!!!
					
					if(seconda.getPezzo()==null){
						if(prima.getColumn() == seconda.getColumn()){
							if(prima.getRow() == (seconda.getRow() + 1)){
								guardaScacco = true;
							}
							else 
								break;
						}			
					}
					else{
						if(prima.getColumn() == (seconda.getColumn() +1) || ( prima.getColumn() == (seconda.getColumn() - 1))){
							if(prima.getRow() == (seconda.getRow() + 1)){
								guardaScacco = true;
							}
							else
								break;
						}
					}
								
				}
				else{
					
					if(seconda.getPezzo()==null){
						if(prima.getColumn() == seconda.getColumn()){
							if(prima.getRow() == (seconda.getRow() - 1)){
								guardaScacco = true;
							}
						} else
							break;
					}
					else{
						if(prima.getColumn() == (seconda.getColumn() +1) || ( prima.getColumn() == (seconda.getColumn() - 1))){
							if(prima.getRow() == (seconda.getRow() - 1)){
								guardaScacco = true;
							}
						}
						else
							break;
					}
				}
				
				break;
					
				
			case "Torre":

				if(seconda.getRow() == prima.getRow()){
					i = prima.getColumn();
					f = seconda.getColumn();
					x = seconda.getRow();
					if(i > f){
						int temp = f;
						f=i;
						i = temp;
					}
					for(int k = f-1; k > i; k--){
						if(squares[x][k].getPezzo() != null){
							possibile = false;
						}
							
					}
				}
				else if(seconda.getColumn() == prima.getColumn()){
					 i = prima.getRow();
					 f = seconda.getRow();
					 y = seconda.getColumn();
						if(i > f){
							int temp = f;
							f=i;
							i = temp;
						}
						for(int k = f-1; k > i; k--){
							if(squares[k][y].getPezzo() != null){
								possibile = false;
							}
								
						}

				}
				else{
					break;
				}
				if(possibile){
					guardaScacco =  true;
				}
				
				break;
				
				
				
			case "Alfiere":	
				//sinistra
				boolean possibileM=false;
				i = prima.getRow() - 1;
				j = prima.getColumn() - 1;

				while(i>=0 && j >= 0){
					if( i == seconda.getRow() && j == seconda.getColumn()){
							possibile = true;
							ii = -1;
							jj = -1;
					}		
					i--;
					j--;
				}
				if(possibile)
					possibileM = controllaSePassaggioLiberoAlfiere(ii,jj);
				i = prima.getRow() - 1;
				j = prima.getColumn() + 1;
				while(i>=0 && j >= 0){
					if( i == seconda.getRow() && j == seconda.getColumn()){
							possibile = true;
							ii = -1;
							jj = +1;
					}		
					i--;
					j++;
				}
				if(possibile)
					possibileM = controllaSePassaggioLiberoAlfiere(ii,jj);
				
				i = prima.getRow() + 1;
				j = prima.getColumn() + 1;
				while(i>=0 && j >= 0){
					if( i == seconda.getRow() && j == seconda.getColumn()){
							possibile = true;
							ii = +1;
							jj = +1;
					}		
					i++;
					j++;
				}
				if(possibile)
					possibileM =  controllaSePassaggioLiberoAlfiere(ii,jj);
				
				i = prima.getRow() + 1;
				j = prima.getColumn() - 1;
				while(i>=0 && j >= 0){
					if( i == seconda.getRow() && j == seconda.getColumn()){
							possibile = true;
							ii = +1;
							jj = -1;
					}		
					i++;
					j--;
				}
				if(possibile)
					possibileM = controllaSePassaggioLiberoAlfiere(ii,jj);

				
				if(possibileM){
					guardaScacco = true;	
				}
				else
					break;
					
				
			case "Cavallo":	
				possibile = false;
				int diffX = Math.abs(prima.getRow() - seconda.getRow());
				int diffY = Math.abs(prima.getColumn() - seconda.getColumn());
				if((diffX == 2 && diffY == 1) || (diffX == 1 && diffY == 2))
					possibile = true;
				if(possibile){
					guardaScacco = true;	
				}
				else
					break;			
				
				
			case "Regina":
				boolean posM=false;
				//guardo se movimento possibile (come torre e alfiere)
				
				
				//come torre
				if(seconda.getRow() == prima.getRow()){
					i = prima.getColumn();
					f = seconda.getColumn();
					x = seconda.getRow();
					if(i > f){
						int temp = f;
						f=i;
						i = temp;
					}
					for(int k = f-1; k > i; k--){
						if(squares[x][k].getPezzo() != null){
							possibile = false;
						}
							
					}
					if(possibile){
						guardaScacco =  true;
						
					}
				}
				else if(seconda.getColumn() == prima.getColumn()){
					 i = prima.getRow();
					 f = seconda.getRow();
					 y = seconda.getColumn();
						if(i > f){
							int temp = f;
							f=i;
							i = temp;
						}
						for(int k = f-1; k > i; k--){
							if(squares[k][y].getPezzo() != null){
								possibile = false;
							}
								
						}

						if(possibile){
							seconda.setPezzo(prima.getPezzo());
							guardaScacco = true;
							
						}
				}
				
			

				//come Alfiere
					i = prima.getRow() - 1;
					j = prima.getColumn() - 1;
					while(i>=0 && j >= 0){
						if( i == seconda.getRow() && j == seconda.getColumn()){
								possibile = true;
								ii = -1;
								jj = -1;
						}		
						i--;
						j--;
					}
					if(possibile)
						posM = controllaSePassaggioLiberoAlfiere(ii,jj);
					i = prima.getRow() - 1;
					j = prima.getColumn() + 1;
					while(i>=0 && j >= 0){
						if( i == seconda.getRow() && j == seconda.getColumn()){
								possibile = true;
								ii = -1;
								jj = +1;
						}		
						i--;
						j++;
					}
					if(possibile)
						posM = controllaSePassaggioLiberoAlfiere(ii,jj);
					
					i = prima.getRow() + 1;
					j = prima.getColumn() + 1;
					while(i>=0 && j >= 0){
						if( i == seconda.getRow() && j ==seconda.getColumn()){
								possibile = true;
								ii = +1;
								jj = +1;
						}		
						i++;
						j++;
					}
					if(possibile)
						posM = controllaSePassaggioLiberoAlfiere(ii,jj);
					
					i = prima.getRow() + 1;
					j = prima.getColumn() - 1;
					while(i>=0 && j >= 0){
						if( i == seconda.getRow() && j == seconda.getColumn()){
								possibile = true;
								ii = +1;
								jj = -1;
						}		
						i++;
						j--;
					}
					if(possibile)
						posM = controllaSePassaggioLiberoAlfiere(ii,jj);

			
				
				if(posM==true){
					guardaScacco = true;	
				}
				else
					break;
				
				
				
			case "Re":	
				diffX = Math.abs(prima.getRow() - seconda.getRow());
				diffY = Math.abs(prima.getColumn() - seconda.getColumn());

					if(prima.getColumn() == seconda.getColumn()){
						if((prima.getRow() == (seconda.getRow() - 1 )|| (prima.getRow() == (seconda.getRow() + 1)))){
							
							guardaScacco = true;
							
						}
					}
					else if(prima.getRow() == seconda.getRow()){
						if((prima.getColumn() == (seconda.getColumn() - 1 )|| (prima.getColumn() == (seconda.getColumn() + 1)))){
							
								guardaScacco = true;
							
						}	
					}	
					else if( diffX == 1 && diffY == 1 ){
						
						guardaScacco = true;
						
						}
					else
						break;				
			
			}
							
}
			
	
	
	

	private boolean controllaSePassaggioLiberoAlfiere(int ii, int jj) {
		 int xi = prima.getRow() + ii;
		 int yi = prima.getColumn() + jj;
		 while(seconda.getRow() != xi ){
			 
			 if(squares[xi][yi].getPezzo() != null){
				 return false;
			 }
			 xi = xi + ii;
			 yi = yi + jj;
		 }

			
		return true;
	}

	private void cambiaTurno() {
		guardaScacco = false;
		if(turno)
			turno = false;
		else
			turno = true;
		
	}
	
	
}
