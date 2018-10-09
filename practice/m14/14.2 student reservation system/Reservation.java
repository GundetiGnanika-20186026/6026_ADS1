class Reservation {
	Student[] reservation;
	int ressize;
	Reservation(){
		reservation = new Student[6];
		ressize = 0;
	}


	public Student[] getArray1(){
		return reservation;
	}


	public int getressize(){
		return ressize;
	}

    //add unreserved
	public void addunreserved(Student[] array,int unresseats) {
		for(int i = 0; i < unresseats; i++){
			reservation[i] = array[i];
			ressize++;
		}
	}

   //add bc
	public void addBc(Student[] array,int bcceats){
		int count = 0;
		for(int i = ressize;count < bcceats;i++) {
			if (array[i].getres().equals("BC")) {
				reservation[i] = array[i];
				count++;
			}

		}
	}

	public void addSc(Student[] array,int scceats){
		int count = 0;
		for(int i = ressize;count < scceats;i++) {
			if (array[i].getres().equals("SC")) {
				reservation[i] = array[i];
				count++;
			}

		}
	}


	public void addSt(Student[] array,int stceats){
		int count = 0;
		for(int i = ressize;count < stceats;i++) {
			if (array[i].getres().equals("ST")) {
				reservation[i] = array[i];
				count++;
			}

		}
	}





}