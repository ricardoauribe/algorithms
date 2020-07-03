

static int[] countingSort(List<Integer> original){
    int len = original.size();
    int[] count = new int[201];
    int[] output = new int[len];

    //clear count
    for(int i=0; i<201; i++){
        count[i]=0;
    }

    //Count incidences per number
    for(int j=0; j<len; j++){
        count[original.get(j)] += 1;
    }

    //Incremental count to determine actual position
    for(int k=1; k<201; k++){
        count[k] += count[k-1];
    }

    //Build output array
    for(int l=0; l<len; l++){
        output[count[original.get(l)]-1] = original.get(l);
        count[original.get(l)]--;
    }

    return output;

}
