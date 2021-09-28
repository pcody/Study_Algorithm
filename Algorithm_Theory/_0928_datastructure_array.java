public class _0928_datastructure_array {
    public static void main(String[] args) {
        // 참조 변수 선언
        int[] arr1;

        // 배열 인스턴스 생성
        arr1 = new int[5];
        // arr2 = {1, 2, 3, 4, 5}; // 불가
        int arr2[] = { 1, 2, 3, 4 };
        int[] arr3 = { 8, 7, 6, 5, 4, 3, 2 };
        int[] arr4 = new int[] { 1, 5, 7 };
        int[][] arr5 = new int[][] { arr1, arr2, arr3, arr4 };
        int arr6[][] = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 1, 2, 2, 3, 4, 5, 6 },
                { 5, 6, 7, 8, 83, 4, 7, 9, 90 } };

        // 사용
        System.out.println(arr1.length);
        System.out.println(arr2.length);

        for (int[] arr : arr5) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
        }

        for (int[] arr : arr6) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
        }

    }
}
