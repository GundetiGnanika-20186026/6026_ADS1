class Reservation {
	Student[] reservation;
	int ressize;
	Reservation(int length) {
		reservation = new Student[length];
		ressize = 0;
	}


	public Student[] getArray1() {
		return reservation;
	}


	public int getRessize() {
		return ressize;
	}

	public void setRessize(){
		ressize++;
	}

	//add unreserved
	public void addUnreserved(Student[] array, int unresseats) {
		for (int i = 0; i < unresseats; i++) {
			reservation[i] = array[i];
			ressize++;
		}
	}

	//add bc
	public void addBc(Student[] array, int bcceats,int listsize) {
		//System.out.println("entered addbc");
		int count = 0;
		for (int i = ressize; count < bcceats  && i < listsize; i++) {
			//for(int j = ressize; j < listsize; j++)
				if (array[i].getRes().equals("BC") ) { //&& count != bcceats)
					reservation[ressize] = array[i];
					ressize++;
					count++;

			}

		}
	}

	//add sc
	public void addSc(Student[] array, int scceats,int listsize) {
		//System.out.println(scceats);
		int count = 0;
		for (int i = ressize; count < scceats && i < listsize; i++) {
			//for(int j = ressize; j < listsize; j++)
				if (array[i].getRes().equals("SC")) { //&& count != bcceats)
					reservation[ressize] = array[i];
					ressize++;
					count++;

			}

		}
	}

	//add st
	public void addSt(Student[] array, int stceats, int listsize) {
		int count = 0;
		for (int i = ressize; count < stceats && i < listsize; i++) {
			//for(int j = ressize; j < listsize; j++)
				if (array[i].getRes().equals("ST")) { //&& count != bcceats)
					reservation[ressize] = array[i];
					ressize++;
					count++;

			}

		}
	}





}