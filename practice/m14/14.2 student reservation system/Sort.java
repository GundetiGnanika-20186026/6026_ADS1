class Sort{
    Sort(){

    }
    /**
     * sort again.
     */
    public  void sortAgain() {
        for (int i = vacanciesList.size() - 1; i >= 0; i--) {
            Student max = vacanciesList.get(i);
            int index = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (max.compareTo(vacanciesList.get(j)) == 1) {
                    max = vacanciesList.get(j);
                    index = j;
                }
            }
            Student temp = vacanciesList.get(i);
            vacanciesList.set(i, max);
            if (index != -1) {
                vacanciesList.set(index, temp);
            }
        }
    }
    /**
     * selction sort
     */
    public  void selectionSort() {
        for (int i = students.size() - 1; i >= 0; i--) {
            Student max = students.get(i);
            int index = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (max.compareTo(students.get(j)) == 1) {
                    max = students.get(j);
                    index = j;
                }
            }
            Student temp = students.get(i);
            students.set(i, max);
            if (index != -1) {
                students.set(index, temp);
            }
        }
    }
}
