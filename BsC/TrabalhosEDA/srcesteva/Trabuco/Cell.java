if (oceano[i][j].getType()==0) {
					if (i==0 && j==0) {
						if (oceano[width()-1-1][height()-1-1].getType()==2 || 
								oceano[i][height()-1-1].getType()==2 || 
								oceano[i+1][height()-1].getType()==2 || 
								oceano[i+1][j].getType()==2 || 
								oceano[i+1][j+1].getType()==2 || 
								oceano[i][j+1].getType()==2 || 
								oceano[width()-1][j+1].getType()==2 || 
								oceano[width()-1][j].getType()==2) {newOcean.oceano[i][j] = oceano[i][j];
						
						}else if (((oceano[width()-1][height()-1].getType()==2 && oceano[i][height()-1].getType()==2) ||
								(oceano[width()-1][height()-1].getType()==2 && oceano[i+1][height()-1].getType()==2) || 
								(oceano[width()-1][height()-1].getType()==2 && oceano[i+1][j].getType()==2) || 
								(oceano[width()-1][height()-1].getType()==2 && oceano[i+1][j+1].getType()==2) || 
								(oceano[width()-1][height()-1].getType()==2 && oceano[i][j+1].getType()==2) || 
								(oceano[width()-1][height()-1].getType()==2 && oceano[width()-1][j+1].getType()==2) || 
								(oceano[width()-1][height()-1].getType()==2 && oceano[width()-1][j].getType()==2) || 
								(oceano[i][height()-1].getType()==2 && oceano[i+1][height()-1].getType()==2) || 
								(oceano[i][height()-1].getType()==2 && oceano[i+1][j].getType()==2) || 
								(oceano[i][height()-1].getType()==2 && oceano[i+1][j+1].getType()==2) || 
								(oceano[i][height()-1].getType()==2 && oceano[i][j+1].getType()==2) || 
								(oceano[i][height()-1].getType()==2 && oceano[width()-1][j+1].getType()==2) || 
								(oceano[i][height()-1].getType()==2 && oceano[width()-1][j].getType()==2) || 
								(oceano[i+1][height()-1].getType()==2 && oceano[i+1][j].getType()==2) || 
								(oceano[i+1][height()-1].getType()==2 && oceano[i+1][j+1].getType()==2) || 
								(oceano[i+1][height()-1].getType()==2 && oceano[i][j+1].getType()==2) || 
								(oceano[i+1][height()-1].getType()==2 && oceano[width()-1][j+1].getType()==2) || 
								(oceano[i+1][height()-1].getType()==2 && oceano[width()-1][j].getType()==2) || 
								(oceano[i+1][j].getType()==2 && oceano[i+1][j+1].getType()==2) || 
								(oceano[i+1][j].getType()==2 && oceano[i][j+1].getType()==2) || 
								(oceano[i+1][j].getType()==2 && oceano[width()-1][j+1].getType()==2) || 
								(oceano[i+1][j].getType()==2 && oceano[width()-1][j].getType()==2) || 
								(oceano[i+1][j+1].getType()==2 && oceano[i][j+1].getType()==2) ||
								(oceano[i+1][j+1].getType()==2 && oceano[width()-1][j+1].getType()==2) || 
								(oceano[i+1][j+1].getType()==2 && oceano[width()-1][j].getType()==2) || 
								(oceano[i][j+1].getType()==2 && oceano[width()-1][j+1].getType()==2) ||
								(oceano[i][j+1].getType()==2 && oceano[width()-1][j].getType()==2) ||
								(oceano[width()-1][j+1].getType()==2 && oceano[width()-1][j].getType()==2)) &&
								(oceano[width()-1][height()-1].getType()==1 || 
								oceano[i][height()-1].getType()==1 ||
								oceano[i+1][height()-1].getType()==1 ||
								oceano[i+1][j].getType()==1 ||
								oceano[i+1][j+1].getType()==1 ||
								oceano[i][j+1].getType()==1 ||
								oceano[width()-1][j+1].getType()==1 ||
								oceano[width()-1][j].getType()==1)) {newOcean.oceano[i][j] = new Pexe();
							
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (i==width()-1 && j==0){
						if (oceano[i-1][height()-1].getType()==2 ||
								oceano[i][height()-1].getType()==2 ||
								oceano[0][height()-1].getType()==2 || 
								oceano[0][0].getType()==2 ||
								oceano[0][j+1].getType()==2 ||
								oceano[i][j+1].getType()==2 ||
								oceano[i-1][j+1].getType()==2 ||
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = oceano[i][j];
								
						}else if (((oceano[i-1][height()-1].getType()==1 && oceano[i][height()-1].getType()==1) ||
								(oceano[i-1][height()-1].getType()==1 && oceano[0][height()-1].getType()==1) || 
								(oceano[i-1][height()-1].getType()==1 && oceano[0][0].getType()==1) || 
								(oceano[i-1][height()-1].getType()==1 && oceano[0][j+1].getType()==1) || 
								(oceano[i-1][height()-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i-1][height()-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i-1][height()-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[0][height()-1].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[0][0].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[0][j+1].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[0][height()-1].getType()==1 && oceano[0][0].getType()==1) || 
								(oceano[0][height()-1].getType()==1 && oceano[0][j+1].getType()==1) || 
								(oceano[0][height()-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[0][height()-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[0][height()-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[0][0].getType()==1 && oceano[0][j+1].getType()==1) || 
								(oceano[0][0].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[0][0].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[0][0].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[0][j+1].getType()==1 && oceano[i][j+1].getType()==1) ||
								(oceano[0][j+1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[0][j+1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][j+1].getType()==1 && oceano[i-1][j+1].getType()==1) ||
								(oceano[i][j+1].getType()==1 && oceano[i-1][j].getType()==1) ||
								(oceano[i-1][j+1].getType()==1 && oceano[i-1][j].getType()==1)) &&
								(oceano[i-1][height()-1].getType()==1 ||
								oceano[i][height()-1].getType()==1 ||
								oceano[0][height()-1].getType()==1 || 
								oceano[0][0].getType()==1 ||
								oceano[0][j+1].getType()==1 ||
								oceano[i][j+1].getType()==1 ||
								oceano[i-1][j+1].getType()==1 ||
								oceano[i-1][j].getType()==1)) {newOcean.oceano[i][j] = new Pexe();		
						
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (i==width()-1 && j==height()-1) {

						if (oceano[i-1][j-1].getType()==2 ||
								oceano[i][j-1].getType()==2 ||
								oceano[0][j-1].getType()==2 || 
								oceano[0][j].getType()==2 ||
								oceano[0][0].getType()==2 || 
								oceano[i][0].getType()==2 ||
								oceano[i-1][0].getType()==2 ||
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = oceano[i][j];
						
						}else if (((oceano[i-1][j-1].getType()==1 && oceano[i][j-1].getType()==1) ||
								(oceano[i-1][j-1].getType()==1 && oceano[0][j-1].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[0][j].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[0][0].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i][0].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i-1][0].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[0][j-1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[0][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[0][0].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i][0].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i-1][0].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[0][j-1].getType()==1 && oceano[0][j].getType()==1) || 
								(oceano[0][j-1].getType()==1 && oceano[0][0].getType()==1) || 
								(oceano[0][j-1].getType()==1 && oceano[i][0].getType()==1) || 
								(oceano[0][j-1].getType()==1 && oceano[i-1][0].getType()==1) || 
								(oceano[0][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[0][j].getType()==1 && oceano[0][0].getType()==1) || 
								(oceano[0][j].getType()==1 && oceano[i][0].getType()==1) || 
								(oceano[0][j].getType()==1 && oceano[i-1][0].getType()==1) || 
								(oceano[0][j].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[0][0].getType()==1 && oceano[i][0].getType()==1) ||
								(oceano[0][0].getType()==1 && oceano[i-1][0].getType()==1) || 
								(oceano[0][0].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][0].getType()==1 && oceano[i-1][0].getType()==1) ||
								(oceano[i][0].getType()==1 && oceano[i-1][j].getType()==1) ||
								(oceano[i-1][0].getType()==1 && oceano[i-1][j].getType()==1)) &&
								(oceano[i-1][j-1].getType()==1 ||
								oceano[i][j-1].getType()==1 ||
								oceano[0][j-1].getType()==1 || 
								oceano[0][j].getType()==1 ||
								oceano[0][0].getType()==1 ||
								oceano[i][0].getType()==1 ||
								oceano[i-1][0].getType()==1 ||
								oceano[i-1][j].getType()==1)) {newOcean.oceano[i][j] = new Pexe();		
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (i==0 && j==height()-1){

						if (oceano[width()-1][j-1].getType()==2 ||
								oceano[i][j-1].getType()==2 ||
								oceano[i+1][j-1].getType()==2 ||
								oceano[i+1][j].getType()==2 ||
								oceano[i+1][0].getType()==2 ||
								oceano[i][0].getType()==2 || 
								oceano[width()-1][0].getType()==2 ||
								oceano[width()-1][j].getType()==2) {newOcean.oceano[i][j] = oceano[i][j];		
						
						}else if (((oceano[width()-1][j-1].getType()==1 && oceano[i][j-1].getType()==1) ||
								(oceano[width()-1][j-1].getType()==1 && oceano[i+1][j-1].getType()==1) || 
								(oceano[width()-1][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[width()-1][j-1].getType()==1 && oceano[i+1][0].getType()==1) || 
								(oceano[width()-1][j-1].getType()==1 && oceano[i][0].getType()==1) || 
								(oceano[width()-1][j-1].getType()==1 && oceano[width()-1][0].getType()==1) || 
								(oceano[width()-1][j-1].getType()==1 && oceano[width()-1][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][j-1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][0].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i][0].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[width()-1][0].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[width()-1][j].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i+1][0].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i][0].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[width()-1][0].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[width()-1][j].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i+1][0].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i][0].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[width()-1][0].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[width()-1][j].getType()==1) || 
								(oceano[i+1][0].getType()==1 && oceano[i][0].getType()==1) ||
								(oceano[i+1][0].getType()==1 && oceano[width()-1][0].getType()==1) || 
								(oceano[i+1][0].getType()==1 && oceano[width()-1][j].getType()==1) || 
								(oceano[i][0].getType()==1 && oceano[width()-1][0].getType()==1) ||
								(oceano[i][0].getType()==1 && oceano[width()-1][j].getType()==1) ||
								(oceano[width()-1][j].getType()==1 && oceano[width()-1][j].getType()==1)) &&
								(oceano[width()-1][j-1].getType()==1 ||
								oceano[i][j-1].getType()==1 ||
								oceano[i+1][j-1].getType()==1 || 
								oceano[i+1][j].getType()==1 ||
								oceano[i+1][0].getType()==1 ||
								oceano[i][0].getType()==1 ||
								oceano[width()-1][0].getType()==1 ||
								oceano[width()-1][j].getType()==1)) {newOcean.oceano[i][j] = new Pexe();		
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (j==0) {
						
						if (oceano[i-1][height()-1].getType()==2 ||
								oceano[i][height()-1].getType()==2 ||
								oceano[i+1][height()-1].getType()==2 ||
								oceano[i+1][j].getType()==2 ||
								oceano[i+1][j+1].getType()==2 ||
								oceano[i][j+1].getType()==2 ||
								oceano[i-1][j+1].getType()==2 ||
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = oceano[i][j];		
						
						}else if (((oceano[i-1][height()-1].getType()==1 && oceano[i][height()-1].getType()==1) ||
								(oceano[i-1][height()-1].getType()==1 && oceano[i+1][height()-1].getType()==1) || 
								(oceano[i-1][height()-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i-1][height()-1].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[i-1][height()-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i-1][height()-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i-1][height()-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[i+1][height()-1].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i+1][height()-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i+1][height()-1].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[i+1][height()-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i+1][height()-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i+1][height()-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i+1][j+1].getType()==1 && oceano[i][j+1].getType()==1) ||
								(oceano[i+1][j+1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i+1][j+1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][j+1].getType()==1 && oceano[i-1][j+1].getType()==1) ||
								(oceano[i][j+1].getType()==1 && oceano[i-1][j].getType()==1) ||
								(oceano[i-1][j+1].getType()==1 && oceano[i-1][j].getType()==1)) &&
								(oceano[i-1][height()-1].getType()==1 ||
								oceano[i][height()-1].getType()==1 ||
								oceano[i+1][height()-1].getType()==1 || 
								oceano[i+1][j].getType()==1 ||
								oceano[i+1][j+1].getType()==1 ||
								oceano[i][j+1].getType()==1 ||
								oceano[i-1][j+1].getType()==1 ||
								oceano[i-1][j].getType()==1)) {newOcean.oceano[i][j] = new Pexe();		
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (i==width()-1) {
						
						if (oceano[i-1][j-1].getType()==2 || 
								oceano[i][j-1].getType()==2 ||
								oceano[0][j-1].getType()==2 ||
								oceano[0][j].getType()==2 || 
								oceano[0][j+1].getType()==2 || 
								oceano[i][j+1].getType()==2 ||
								oceano[i-1][j+1].getType()==2 || 
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = oceano[i][j];	
						
						}else if (((oceano[i-1][j-1].getType()==1 && oceano[i][j-1].getType()==1) ||
								(oceano[i-1][j-1].getType()==1 && oceano[0][j-1].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[0][j].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[0][j+1].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[0][j-1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[0][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[0][j+1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[0][j-1].getType()==1 && oceano[0][j].getType()==1) || 
								(oceano[0][j-1].getType()==1 && oceano[0][j+1].getType()==1) || 
								(oceano[0][j-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[0][j-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[0][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[0][j].getType()==1 && oceano[0][j+1].getType()==1) || 
								(oceano[0][j].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[0][j].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[0][j].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[0][j+1].getType()==1 && oceano[i][j+1].getType()==1) ||
								(oceano[0][j+1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[0][j+1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][j+1].getType()==1 && oceano[i-1][j+1].getType()==1) ||
								(oceano[i][j+1].getType()==1 && oceano[i-1][j].getType()==1) ||
								(oceano[i-1][j+1].getType()==1 && oceano[i-1][j].getType()==1)) &&
								(oceano[i-1][j-1].getType()==1 ||
								oceano[i][j-1].getType()==1 ||
								oceano[0][j-1].getType()==1 || 
								oceano[0][j].getType()==1 ||
								oceano[0][j+1].getType()==1 ||
								oceano[i][j+1].getType()==1 ||
								oceano[i-1][j+1].getType()==1 ||
								oceano[i-1][j].getType()==1)) {newOcean.oceano[i][j] = new Pexe();		
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (j==height()-1){
							
						if (oceano[i-1][j-1].getType()==2 ||
								oceano[i][j-1].getType()==2 || 
								oceano[i+1][j-1].getType()==2 ||
								oceano[i+1][j].getType()==2 ||
								oceano[i+1][0].getType()==2 ||
								oceano[i][0].getType()==2 || 
								oceano[i-1][0].getType()==2 || 
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = oceano[i][j];		
						
						}else if (((oceano[i-1][j-1].getType()==1 && oceano[i][j-1].getType()==1) ||
								(oceano[i-1][j-1].getType()==1 && oceano[i+1][j-1].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i+1][0].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i][0].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i-1][0].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][j-1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][0].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i][0].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i-1][0].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i+1][0].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i][0].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i-1][0].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[0][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i+1][0].getType()==1 && oceano[i][j+1].getType()==1) ||
								(oceano[i+1][0].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i+1][0].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][0].getType()==1 && oceano[i-1][0].getType()==1) ||
								(oceano[i][0].getType()==1 && oceano[i-1][j].getType()==1) ||
								(oceano[i-1][0].getType()==1 && oceano[i-1][j].getType()==1)) &&
								(oceano[i-1][j-1].getType()==1 ||
								oceano[i][j-1].getType()==1 ||
								oceano[i+1][j-1].getType()==1 || 
								oceano[i+1][j].getType()==1 ||
								oceano[i+1][0].getType()==1 ||
								oceano[i][0].getType()==1 ||
								oceano[i-1][0].getType()==1 ||
								oceano[i-1][j].getType()==1)) {newOcean.oceano[i][j] = new Pexe();		
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (i==0) {
						
						if (oceano[width()-1][j-1].getType()==2 ||
								oceano[i][j-1].getType()==2 ||
								oceano[i+1][j-1].getType()==2 || 
								oceano[i+1][j].getType()==2 || 
								oceano[i+1][j+1].getType()==2 ||
								oceano[i][j+1].getType()==2 ||
								oceano[width()-1][j+1].getType()==2 ||
								oceano[width()-1][j].getType()==2) {newOcean.oceano[i][j] = oceano[i][j];
								
						}else if (((oceano[width()-1][j-1].getType()==1 && oceano[i][j-1].getType()==1) ||
								(oceano[width()-1][j-1].getType()==1 && oceano[i+1][j-1].getType()==1) || 
								(oceano[width()-1][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[width()-1][j-1].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[width()-1][j-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[width()-1][j-1].getType()==1 && oceano[width()-1][j+1].getType()==1) || 
								(oceano[width()-1][j-1].getType()==1 && oceano[width()-1][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][j-1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[width()-1][j+1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[width()-1][j].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[width()-1][j+1].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[width()-1][j].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[width()-1][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[width()-1][j].getType()==1) || 
								(oceano[i+1][j+1].getType()==1 && oceano[i][j+1].getType()==1) ||
								(oceano[i+1][j+1].getType()==1 && oceano[width()-1][j+1].getType()==1) || 
								(oceano[i+1][j+1].getType()==1 && oceano[width()-1][j].getType()==1) || 
								(oceano[i][j+1].getType()==1 && oceano[width()-1][j+1].getType()==1) ||
								(oceano[i][j+1].getType()==1 && oceano[width()-1][j].getType()==1) ||
								(oceano[width()-1][j+1].getType()==1 && oceano[width()-1][j].getType()==1)) &&
								(oceano[width()-1][j-1].getType()==1 ||
								oceano[i][j-1].getType()==1 ||
								oceano[i+1][j-1].getType()==1 || 
								oceano[i+1][j].getType()==1 ||
								oceano[i+1][j+1].getType()==1 ||
								oceano[i][j+1].getType()==1 ||
								oceano[width()-1][j+1].getType()==1 ||
								oceano[width()-1][j].getType()==1)) {newOcean.oceano[i][j] = new Pexe();		
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else {
						
						if (oceano[i-1][j-1].getType()==2 ||
								oceano[i][j-1].getType()==2 || 
								oceano[i+1][j-1].getType()==2 || 
								oceano[i+1][j].getType()==2 ||
								oceano[i+1][j+1].getType()==2 || 
								oceano[i][j+1].getType()==2 ||
								oceano[i-1][j+1].getType()==2 ||
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = oceano[i][j];		
						
						}else if (((oceano[i-1][j-1].getType()==1 && oceano[i][j-1].getType()==1) ||
								(oceano[i-1][j-1].getType()==1 && oceano[i+1][j-1].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][j-1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i+1][j+1].getType()==1 && oceano[i][j+1].getType()==1) ||
								(oceano[i+1][j+1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i+1][j+1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][j+1].getType()==1 && oceano[i-1][j+1].getType()==1) ||
								(oceano[i][j+1].getType()==1 && oceano[i-1][j].getType()==1) ||
								(oceano[i-1][j+1].getType()==1 && oceano[i-1][j].getType()==1)) &&
								(oceano[i-1][j-1].getType()==1 ||
								oceano[i][j-1].getType()==1 ||
								oceano[i+1][j-1].getType()==1 || 
								oceano[i+1][j].getType()==1 ||
								oceano[i+1][j+1].getType()==1 ||
								oceano[i][j+1].getType()==1 ||
								oceano[i-1][j+1].getType()==1 ||
								oceano[i-1][j].getType()==1)) {newOcean.oceano[i][j] = new Pexe();		
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}

				
				//Pexes...
				}else if (oceano[i][j].getType()==2) {
					if (i==0 && j==0) {
						if ((oceano[width()-1][height()-1].getType()==2 || oceano[width()-1][height()-1].getType()==0) && 
								(oceano[i][height()-1].getType()==2 || oceano[i][height()-1].getType()==0) && 
								(oceano[i+1][height()-1].getType()==2 || oceano[i+1][height()-1].getType()==0) && 
								(oceano[i+1][j].getType()==2 || oceano[i+1][j].getType()==0) && 
								(oceano[i+1][j+1].getType()==2 || oceano[i+1][j+1].getType()==0) && 
								(oceano[i][j+1].getType()==2 || oceano[i][j+1].getType()==0) && 
								(oceano[width()-1][j+1].getType()==2 || oceano[width()-1][j+1].getType()==0) && 
								(oceano[width()-1][j].getType()==2 || oceano[width()-1][j].getType()==0)) {newOcean.oceano[i][j] = oceano[i][j];
								
						}else if (oceano[width()-1][height()-1].getType()==1 ||
								oceano[i][height()-1].getType()==1 ||
								oceano[i+1][height()-1].getType()==1 ||
								oceano[i+1][j].getType()==1 ||
								oceano[i+1][j+1].getType()==1 ||
								oceano[i][j+1].getType()==1 ||
								oceano[width()-1][j+1].getType()==1 ||
								oceano[width()-1][j].getType()==1) {newOcean.oceano[i][j] = new Nada();
							
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (i==width()-1 && j==0){
						if ((oceano[i-1][height()-1].getType()==2 || oceano[i-1][height()-1].getType()==0) && 
								(oceano[i][height()-1].getType()==2 || oceano[i][height()-1].getType()==0) && 
								(oceano[0][height()-1].getType()==2 || oceano[0][height()-1].getType()==0) && 
								(oceano[0][0].getType()==2 || oceano[0][0].getType()==0) && 
								(oceano[0][j+1].getType()==2 || oceano[0][j+1].getType()==0) && 
								(oceano[i][j+1].getType()==2 || oceano[i][j+1].getType()==0) && 
								(oceano[i-1][j+1].getType()==2 || oceano[i-1][j+1].getType()==0) && 
								(oceano[i-1][j].getType()==2 || oceano[i-1][j].getType()==0)) {newOcean.oceano[i][j] = oceano[i][j];
								
						}else if (oceano[i-1][height()-1].getType()==1 ||
								oceano[i][height()-1].getType()==1 ||
								oceano[0][height()-1].getType()==1 || 
								oceano[0][0].getType()==1 ||
								oceano[0][j+1].getType()==1 ||
								oceano[i][j+1].getType()==1 ||
								oceano[i-1][j+1].getType()==1 ||
								oceano[i-1][j].getType()==1) {newOcean.oceano[i][j] = new Nada();
						
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (i==width()-1 && j==height()-1) {
						if ((oceano[i-1][j-1].getType()==2 || oceano[i-1][j-1].getType()==0) && 
								(oceano[i][j-1].getType()==2 || oceano[i][j-1].getType()==0) && 
								(oceano[0][j-1].getType()==2 || oceano[0][j-1].getType()==0) && 
								(oceano[0][j].getType()==2 || oceano[0][j].getType()==0) && 
								(oceano[0][0].getType()==2 || oceano[0][0].getType()==0) && 
								(oceano[i][0].getType()==2 || oceano[i][0].getType()==0) && 
								(oceano[i-1][0].getType()==2 || oceano[i-1][0].getType()==0) && 
								(oceano[i-1][j].getType()==2 || oceano[i-1][j].getType()==0)) {newOcean.oceano[i][j] = oceano[i][j];
						
						}else if (oceano[i-1][j-1].getType()==1 ||
								oceano[i][j-1].getType()==1 ||
								oceano[0][j-1].getType()==1 || 
								oceano[0][j].getType()==1 ||
								oceano[0][0].getType()==1 || 
								oceano[i][0].getType()==1 ||
								oceano[i-1][0].getType()==1 ||
								oceano[i-1][j].getType()==1) {newOcean.oceano[i][j] = new Nada();
						
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (i==0 && j==height()-1){
						if ((oceano[width()-1][j-1].getType()==2 || oceano[width()-1][j-1].getType()==0) && 
								(oceano[i][j-1].getType()==2 || oceano[i][j-1].getType()==0) && 
								(oceano[i+1][j-1].getType()==2 || oceano[i+1][j-1].getType()==0) && 
								(oceano[i+1][j].getType()==2 || oceano[i+1][j].getType()==0) && 
								(oceano[i+1][0].getType()==2 || oceano[i+1][0].getType()==0) && 
								(oceano[i][0].getType()==2 || oceano[i][0].getType()==0) && 
								(oceano[width()-1][0].getType()==2 || oceano[width()-1][0].getType()==0) && 
								(oceano[width()-1][j].getType()==2 || oceano[width()-1][j].getType()==0)) {newOcean.oceano[i][j] = oceano[i][j];
						
						}else if (oceano[width()-1][j-1].getType()==1 ||
								oceano[i][j-1].getType()==1 ||
								oceano[i+1][j-1].getType()==1 ||
								oceano[i+1][j].getType()==1 ||
								oceano[i+1][0].getType()==1 ||
								oceano[i][0].getType()==1 || 
								oceano[width()-1][0].getType()==1 ||
								oceano[width()-1][j].getType()==1) {newOcean.oceano[i][j] = new Nada();		
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (j==0) {
						if ((oceano[i-1][height()-1].getType()==2 || oceano[i-1][height()-1].getType()==0) && 
								(oceano[i][height()-1].getType()==2 || oceano[i][height()-1].getType()==0) && 
								(oceano[i+1][height()-1].getType()==2 || oceano[i+1][height()-1].getType()==0) && 
								(oceano[i+1][j].getType()==2 || oceano[i+1][j].getType()==0) && 
								(oceano[i+1][j+1].getType()==2 || oceano[i+1][j+1].getType()==0) && 
								(oceano[i][j+1].getType()==2 || oceano[i][j+1].getType()==0) && 
								(oceano[i-1][j+1].getType()==2 || oceano[i-1][j+1].getType()==0) && 
								(oceano[i-1][j].getType()==2 || oceano[i-1][j].getType()==0)) {newOcean.oceano[i][j] = oceano[i][j];
						
						}else if (oceano[i-1][height()-1].getType()==1 ||
								oceano[i][height()-1].getType()==1 ||
								oceano[i+1][height()-1].getType()==1 ||
								oceano[i+1][j].getType()==1 ||
								oceano[i+1][j+1].getType()==1 ||
								oceano[i][j+1].getType()==1 ||
								oceano[i-1][j+1].getType()==1 ||
								oceano[i-1][j].getType()==1) {newOcean.oceano[i][j] = new Nada();		
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (i==width()-1) {
						if ((oceano[i-1][j-1].getType()==2 || oceano[i-1][j-1].getType()==0) && 
								(oceano[i][j-1].getType()==2 || oceano[i][j-1].getType()==0) && 
								(oceano[0][j-1].getType()==2 || oceano[0][j-1].getType()==0) && 
								(oceano[0][j].getType()==2 || oceano[0][j].getType()==0) && 
								(oceano[0][j+1].getType()==2 || oceano[0][j+1].getType()==0) && 
								(oceano[i][j+1].getType()==2 || oceano[i][j+1].getType()==0) && 
								(oceano[i-1][j+1].getType()==2 || oceano[i-1][j+1].getType()==0) && 
								(oceano[i-1][j].getType()==2 || oceano[i-1][j].getType()==0)) {newOcean.oceano[i][j] = oceano[i][j];
						
						}else if (oceano[i-1][j-1].getType()==1 || 
								oceano[i][j-1].getType()==1 ||
								oceano[0][j-1].getType()==1 ||
								oceano[0][j].getType()==1 || 
								oceano[0][j+1].getType()==1 || 
								oceano[i][j+1].getType()==1 ||
								oceano[i-1][j+1].getType()==1 || 
								oceano[i-1][j].getType()==1) {newOcean.oceano[i][j] = new Nada();	
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (j==height()-1){
						if ((oceano[i-1][j-1].getType()==2 || oceano[i-1][j-1].getType()==0) && 
								(oceano[i][j-1].getType()==2 || oceano[i][j-1].getType()==0) && 
								(oceano[i+1][j-1].getType()==2 || oceano[i+1][j-1].getType()==0) && 
								(oceano[i+1][j].getType()==2 || oceano[i+1][j].getType()==0) && 
								(oceano[i+1][0].getType()==2 || oceano[i+1][0].getType()==0) && 
								(oceano[i][0].getType()==2 || oceano[i][0].getType()==0) && 
								(oceano[i-1][0].getType()==2 || oceano[i-1][0].getType()==0) && 
								(oceano[i-1][j].getType()==2 || oceano[i-1][j].getType()==0)) {newOcean.oceano[i][j] = oceano[i][j];
							
						}else if (oceano[i-1][j-1].getType()==1 ||
								oceano[i][j-1].getType()==1 || 
								oceano[i+1][j-1].getType()==1 ||
								oceano[i+1][j].getType()==1 ||
								oceano[i+1][0].getType()==1 ||
								oceano[i][0].getType()==1 || 
								oceano[i-1][0].getType()==1 || 
								oceano[i-1][j].getType()==1) {newOcean.oceano[i][j] = new Nada();		
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (i==0) {
						if ((oceano[width()-1][j-1].getType()==2 || oceano[width()-1][j-1].getType()==0) && 
								(oceano[i][j-1].getType()==2 || oceano[i][j-1].getType()==0) && 
								(oceano[i+1][j-1].getType()==2 || oceano[i+1][j-1].getType()==0) && 
								(oceano[i+1][j].getType()==2 || oceano[i+1][j].getType()==0) && 
								(oceano[i+1][j+1].getType()==2 || oceano[i+1][j+1].getType()==0) && 
								(oceano[i][j+1].getType()==2 || oceano[i][j+1].getType()==0) && 
								(oceano[width()-1][j+1].getType()==2 || oceano[width()-1][j+1].getType()==0) && 
								(oceano[width()-1][j].getType()==2 || oceano[width()-1][j].getType()==0)) {newOcean.oceano[i][j] = oceano[i][j];
						
						}else if (oceano[width()-1][j-1].getType()==1 ||
								oceano[i][j-1].getType()==1 ||
								oceano[i+1][j-1].getType()==1 || 
								oceano[i+1][j].getType()==1 || 
								oceano[i+1][j+1].getType()==1 ||
								oceano[i][j+1].getType()==1 ||
								oceano[width()-1][j+1].getType()==1 ||
								oceano[width()-1][j].getType()==1) {newOcean.oceano[i][j] = new Nada();
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else {
						if ((oceano[i-1][j-1].getType()==2 || oceano[i-1][j-1].getType()==0) && 
								(oceano[i][j-1].getType()==2 || oceano[i][j-1].getType()==0) && 
								(oceano[i+1][j-1].getType()==2 || oceano[i+1][j-1].getType()==0) && 
								(oceano[i+1][j].getType()==2 || oceano[i+1][j].getType()==0) && 
								(oceano[i+1][j+1].getType()==2 || oceano[i+1][j+1].getType()==0) && 
								(oceano[i][j+1].getType()==2 || oceano[i][j+1].getType()==0) && 
								(oceano[i-1][j+1].getType()==2 || oceano[i-1][j+1].getType()==0) && 
								(oceano[i-1][j].getType()==2 || oceano[i-1][j].getType()==0)) {newOcean.oceano[i][j] = oceano[i][j];
						
						}else if (oceano[i-1][j-1].getType()==1 ||
								oceano[i][j-1].getType()==1 || 
								oceano[i+1][j-1].getType()==1 || 
								oceano[i+1][j].getType()==1 ||
								oceano[i+1][j+1].getType()==1 || 
								oceano[i][j+1].getType()==1 ||
								oceano[i-1][j+1].getType()==1 ||
								oceano[i-1][j].getType()==1) {newOcean.oceano[i][j] = new Nada();		
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}
					
				//Tubaralhos...
				}else if ((oceano[i][j].getType()==1)){
					if (i==0 && j==0) {
						if (oceano[width()-1][height()-1].getType()==2 ||
								oceano[i][height()-1].getType()==2 ||
								oceano[i+1][height()-1].getType()==2 ||
								oceano[i+1][j].getType()==2 ||
								oceano[i+1][j+1].getType()==2 ||
								oceano[i][j+1].getType()==2 ||
								oceano[width()-1][j+1].getType()==2 ||
								oceano[width()-1][j].getType()==2) {newOcean.oceano[i][j] = new Tubaralho(starveTime());
						}else {
							if (oceano[i][j].starveTime == 1) {
								newOcean.oceano[i][j] = new Nada();
							}else {
								newOcean.oceano[i][j] = new Tubaralho(oceano[i][j].starveTime-1);
							}
						}
					}else if (i==width()-1 && j==0){
						if (oceano[i-1][height()-1].getType()==2 ||
								oceano[i][height()-1].getType()==2 || 
								oceano[0][height()-1].getType()==2 ||
								oceano[0][0].getType()==2 ||
								oceano[0][j+1].getType()==2 || 
								oceano[i][j+1].getType()==2 ||
								oceano[i-1][j+1].getType()==2 ||
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = new Tubaralho(starveTime());
						}else {
							if (oceano[i][j].starveTime == 1) {
								newOcean.oceano[i][j] = new Nada();
							}else {
								newOcean.oceano[i][j] = new Tubaralho(oceano[i][j].starveTime-1);
							}
						}
					}else if (i==width()-1 && j==height()-1) {
						if (oceano[i-1][j-1].getType()==2 ||
								oceano[i][j-1].getType()==2 || 
								oceano[0][j-1].getType()==2 || 
								oceano[0][j].getType()==2 || 
								oceano[0][0].getType()==2 ||
								oceano[i][0].getType()==2 ||
								oceano[i-1][0].getType()==2 ||
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = new Tubaralho(starveTime());
						}else {
							if (oceano[i][j].starveTime == 1) {
								newOcean.oceano[i][j] = new Nada();
							}else {
								newOcean.oceano[i][j] = new Tubaralho(oceano[i][j].starveTime-1);
							}
						}
					}else if (i==0 && j==height()-1){
						if (oceano[width()-1][j-1].getType()==2 ||
								oceano[i][j-1].getType()==2 ||
								oceano[i+1][j-1].getType()==2 ||
								oceano[i+1][j].getType()==2 ||
								oceano[i+1][0].getType()==2 ||
								oceano[i][0].getType()==2 ||
								oceano[width()-1][0].getType()==2 ||
								oceano[width()-1][j].getType()==2) {newOcean.oceano[i][j] = new Tubaralho(starveTime());
						}else {
							if (oceano[i][j].starveTime == 1) {
								newOcean.oceano[i][j] = new Nada();
							}else {
								newOcean.oceano[i][j] = new Tubaralho(oceano[i][j].starveTime-1);
							}						}
					}else if (j==0) {
						if (oceano[i-1][height()-1].getType()==2 ||
								oceano[i][height()-1].getType()==2 ||
								oceano[i+1][height()-1].getType()==2 ||
								oceano[i+1][j].getType()==2 ||
								oceano[i+1][j+1].getType()==2 ||
								oceano[i][j+1].getType()==2 ||
								oceano[i-1][j+1].getType()==2 ||
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = new Tubaralho(starveTime());
						}else {
							if (oceano[i][j].starveTime == 1) {
								newOcean.oceano[i][j] = new Nada();
							}else {
								newOcean.oceano[i][j] = new Tubaralho(oceano[i][j].starveTime-1);
							}						}
					}else if (i==width()-1) {
						if (oceano[i-1][j-1].getType()==2 ||
								oceano[i][j-1].getType()==2 || 
								oceano[0][j-1].getType()==2 ||
								oceano[0][j].getType()==2 ||
								oceano[0][j+1].getType()==2 || 
								oceano[i][j+1].getType()==2 ||
								oceano[i-1][j+1].getType()==2 ||
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = new Tubaralho(starveTime());
						}else {
							if (oceano[i][j].starveTime == 1) {
								newOcean.oceano[i][j] = new Nada();
							}else {
								newOcean.oceano[i][j] = new Tubaralho(oceano[i][j].starveTime-1);
							}						}
					}else if (j==height()-1){
						if (oceano[i-1][j-1].getType()==2 ||
								oceano[i][j-1].getType()==2 ||
								oceano[i+1][j-1].getType()==2 ||
								oceano[i+1][j].getType()==2 ||
								oceano[i+1][0].getType()==2 ||
								oceano[i][0].getType()==2 ||
								oceano[i-1][0].getType()==2 ||
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = new Tubaralho(starveTime());
						}else {
							if (oceano[i][j].starveTime == 1) {
								newOcean.oceano[i][j] = new Nada();
							}else {
								newOcean.oceano[i][j] = new Tubaralho(oceano[i][j].starveTime-1);
							}						}
					}else if (i==0) {
						if (oceano[width()-1][j-1].getType()==2 ||
								oceano[i][j-1].getType()==2 || 
								oceano[i+1][j-1].getType()==2 || 
								oceano[i+1][j].getType()==2 ||
								oceano[i+1][j+1].getType()==2 ||
								oceano[i][j+1].getType()==2 ||
								oceano[width()-1][j+1].getType()==2 ||
								oceano[width()-1][j].getType()==2) {newOcean.oceano[i][j] = new Tubaralho(starveTime());
						}else {
							if (oceano[i][j].starveTime == 1) {
								newOcean.oceano[i][j] = new Nada();
							}else {
								newOcean.oceano[i][j] = new Tubaralho(oceano[i][j].starveTime-1);
							}						}
					}else {
						if (oceano[i-1][j-1].getType()==2 || 
								oceano[i][j-1].getType()==2 ||
								oceano[i+1][j-1].getType()==2 ||
								oceano[i+1][j].getType()==2 ||
								oceano[i+1][j+1].getType()==2 || 
								oceano[i][j+1].getType()==2 || 
								oceano[i-1][j+1].getType()==2 ||
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = new Tubaralho(starveTime());
						}else {
							if (oceano[i][j].starveTime == 1) {
								newOcean.oceano[i][j] = new Nada();
							}else {
								newOcean.oceano[i][j] = new Tubaralho(oceano[i][j].starveTime-1);
							}						}
					}
				}
			}
		}