package binarySearch;


class VersionControl{
    private int badVersion;

    public VersionControl(int badVersion){
        this.badVersion = badVersion;
    }

    public boolean isBadVersion(int version){
        return version >= badVersion;
    }
}

public class FirstBadVersion extends VersionControl{
    public FirstBadVersion(int badversion){
        super(badversion);
    }


    public int firstBadVersion(int n) {
    int left = 1;
    int right = n;

    while (left < right){
        int mid = left + (right - left) / 2;

        if (isBadVersion(mid)) right = mid;
        else left = mid + 1;
    }
    return left;
    }

    public static void main(String[] args) {
        FirstBadVersion sol1 = new FirstBadVersion(4);
        System.out.println(sol1.firstBadVersion(5)); // 4

        FirstBadVersion sol2 = new FirstBadVersion(1);
        System.out.println(sol1.firstBadVersion(1)); // 4
    }
}
