

public double getPercentUnderBed(List<Monster> monsters){

	int totalUnderBed = 0;
	
	int counter;
	for(counter = 0; counter < monsters.size(); counter++){
		
		if(monsters.get(counter).isUnderBed()){
			totalUnderBed++;
		}
	}

	return (double)totalUnderBed * 100 / (double) monsters.size();
}