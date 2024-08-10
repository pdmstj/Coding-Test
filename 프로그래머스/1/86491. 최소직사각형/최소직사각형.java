class Solution {
    public int solution(int[][] sizes) {
        for(int i=0; i<sizes.length; i++) {
        	if(sizes[i][0] < sizes[i][1]) {
        		int tmp = sizes[i][0];
        		sizes[i][0] = sizes[i][1];
        		sizes[i][1] = tmp;
        	}
        }
        
        int max_width = sizes[0][0];
        int max_height = sizes[0][1];
        for(int[] size : sizes) {
        	max_width = (max_width < size[0]) ? size[0] : max_width;
        	max_height = (max_height < size[1]) ? size[1] : max_height;
        }
        
        return max_width*max_height;
    }
}