
public class find_smallest_letter_744 {


	public char nextGreatestLetter_linear_scan(char[] letters, char target) {
		//time complexity O(N),space complexity O(1)
        for (int i=0;i<letters.length;i++){
            if (letters[i]>target) return letters[i];
        }
        return letters[0];
    }
	
    public char nextGreatestLetter_label_scan(char[] letters, char target) {
    	//time complexity O(N),space complexity O(1)
        boolean[] seen = new boolean[26];
        for (char c: letters)
            seen[c - 'a'] = true;

        while (true) {
            target++;
            if (target > 'z') target = 'a';
            if (seen[target - 'a']) return target;
        }
    }
    
    public char nextGreatestLetter_binary_search(char[] letters, char target) {
    	//time complexity O(logN),space complexity O(1), since we only store the pointer
    	int lo = 0, hi = letters.length;
    	while (lo < hi) {
    		int mi = lo + (hi - lo) / 2;
    		if (letters[mi] <= target) lo = mi + 1;
    		else hi = mi;
    	}
    	return letters[lo % letters.length];
}

}

