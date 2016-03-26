public class StreetParking {
    public static int freeParks(String street) {
        int len = street.length();
        int tot=0;
        
        for(int i=0; i < len; i++) {
            if(street.charAt(i) == '-') {
                if(i-1 >= 0 && street.charAt(i-1) == 'S') continue;
                if(i+1 < len && (street.charAt(i+1) == 'B' || street.charAt(i+1) == 'S')) continue;
				if(i+2 < len && street.charAt(i+2) == 'B') continue;
					tot++;
            }
        }
        
        return tot;
    }

	public static void main(String[] args) {
		System.out.println(freeParks("---B--S-D--S--"));
		System.out.println(freeParks("DDBDDBDDBDD"));
		System.out.println(freeParks("--S--S--S--S--"));
		System.out.println(freeParks("SSD-B---BD-DDSB-----S-S--------S-B----BSB-S--B-S-D"));
	}
}
