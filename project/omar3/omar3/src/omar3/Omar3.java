//package omar3;

import java.util.Scanner;

// 1. Club Class
class Club {
    String name;
    int branches;
    String manager;
    String location;

    public Club(String name, int branches, String manager, String location) {
        this.name = name;
        this.branches = branches;
        this.manager = manager;
        this.location = location;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return "Club [Name=" + name + ", Branches=" + branches + ", Manager=" + manager + ", Location=" + location + "]";
    }
}

// 2. Member Class
class Member {
    int id;
    String name;
    String phone;
    int numberOfChildren;

    public Member(int id, String name, String phone, int numberOfChildren) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.numberOfChildren = numberOfChildren;
    }

    public int getId() { return id; }

    @Override
    public String toString() {
        return "Member [ID=" + id + ", Name=" + name + ", Phone=" + phone + ", Children=" + numberOfChildren + "]";
    }
}

// 3. Sport Class
class Sport {
    String name;
    int id;
    int numberOfTeams;

    public Sport(String name, int id, int numberOfTeams) {
        this.name = name;
        this.id = id;
        this.numberOfTeams = numberOfTeams;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return "Sport [Name=" + name + ", ID=" + id + ", Teams=" + numberOfTeams + "]";
    }
}


class SystemAlgorithms {


    // 1. Merge Sort for Clubs (By Name) 
    public static void mergeSortClubs(Club[] arr, int left, int right) {
        if (left < right) {
            int mid = (right - left) / 2;
            mergeSortClubs(arr, left, mid);
            mergeSortClubs(arr, mid + 1, right);
            mergeClubs(arr, left, mid, right);
        }
    }

    private static void mergeClubs(Club[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        Club[] L = new Club[n1];
        Club[] R = new Club[n2];

        for (int i = 0; i < n1; ++i) L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i].getName().compareToIgnoreCase(R[j].getName()) <= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) { arr[k] = L[i]; i++; k++; }
        while (j < n2) { arr[k] = R[j]; j++; k++; }
    }

    // 2. Quick Sort for Members (By ID) 
    public static void quickSortMembers(Member[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionMembers(arr, low, high);
            quickSortMembers(arr, low, pi - 1);
            quickSortMembers(arr, pi + 1, high);
        }
    }

    private static int partitionMembers(Member[] arr, int low, int high) {

        int mid = (low + high) / 2;
        int pivot = arr[mid].getId();

        Member tempMid = arr[mid];
        arr[mid] = arr[high];
        arr[high] = tempMid;

        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j].getId() <= pivot) {
                i++;
                Member temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Member temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    // 3. Insertion Sort for Sports (By Name) 
    public static void insertionSortSports(Sport[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            Sport key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getName().compareToIgnoreCase(key.getName()) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

 

    // Binary Search for Club by Name 
    public static int binarySearchClubByName(Club[] arr, String targetName) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = arr[mid].getName().compareToIgnoreCase(targetName);
            if (cmp == 0) return mid;
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1; 
    }

    // Binary Search for Member by ID 
    public static int binarySearchMemberById(Member[] arr, int targetId) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid].getId() == targetId) return mid;
            if (arr[mid].getId() < targetId) left = mid + 1;
            else right = mid - 1;
        }
        return -1; 
    }
}




public class Omar3 {
     public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Club[] clubs = null;
        Member[] members = null;
        Sport[] sports = null;

        boolean clubsAdded = false;
        boolean membersAdded = false;
        boolean sportsAdded = false;

        int choice;

        do {

            System.out.println("\n===== Club System Menu =====");

            if (!clubsAdded)
                System.out.println("1. Add Clubs");

            if (!membersAdded)
                System.out.println("2. Add Members");

            if (!sportsAdded)
                System.out.println("3. Add Sports");

            System.out.println("4. Search Club");
            System.out.println("5. Search Member");

            if (clubsAdded)
                System.out.println("6. Show Clubs");

            if (membersAdded)
                System.out.println("7. Show Members");

            if (sportsAdded)
                System.out.println("8. Show Sports");

            System.out.println("0. Exit");

            System.out.print("Enter Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // Add Clubs
                case 1:

                    if (!clubsAdded) {

                        System.out.print("Number of clubs: ");
                        int n = scanner.nextInt();
                        scanner.nextLine();

                        clubs = new Club[n];

                        for (int i = 0; i < n; i++) {

                            System.out.println("\nClub " + (i + 1));

                            System.out.print("Name: ");
                            String name = scanner.nextLine();

                            System.out.print("Branches: ");
                            int branches = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Manager: ");
                            String manager = scanner.nextLine();

                            System.out.print("Location: ");
                            String location = scanner.nextLine();

                            clubs[i] = new Club(name, branches, manager, location);
                        }

                        SystemAlgorithms.mergeSortClubs(clubs, 0, clubs.length - 1);

                        clubsAdded = true;

                        System.out.println("Clubs Added & Sorted");
                    }

                    break;


                // Add Members
                case 2:

                    if (!membersAdded) {

                        System.out.print("Number of members: ");
                        int n = scanner.nextInt();
                        scanner.nextLine();

                        members = new Member[n];

                        for (int i = 0; i < n; i++) {

                            System.out.println("\nMember " + (i + 1));

                            System.out.print("ID: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Name: ");
                            String name = scanner.nextLine();

                            System.out.print("Phone: ");
                            String phone = scanner.nextLine();

                            System.out.print("Children: ");
                            int children = scanner.nextInt();
                            scanner.nextLine();

                            members[i] = new Member(id, name, phone, children);
                        }

                        SystemAlgorithms.quickSortMembers(members, 0, members.length - 1);

                        membersAdded = true;

                        System.out.println("Members Added & Sorted");
                    }

                    break;


                // Add Sports
                case 3:

                    if (!sportsAdded) {

                        System.out.print("Number of sports: ");
                        int n = scanner.nextInt();
                        scanner.nextLine();

                        sports = new Sport[n];

                        for (int i = 0; i < n; i++) {

                            System.out.println("\nSport " + (i + 1));

                            System.out.print("Name: ");
                            String name = scanner.nextLine();

                            System.out.print("ID: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Teams: ");
                            int teams = scanner.nextInt();
                            scanner.nextLine();

                            sports[i] = new Sport(name, id, teams);
                        }

                        SystemAlgorithms.insertionSortSports(sports);

                        sportsAdded = true;

                        System.out.println("Sports Added & Sorted");
                    }

                    break;


                // Search Club
                case 4:

                    if (clubsAdded) {

                        System.out.print("Enter Club Name: ");
                        String name = scanner.nextLine();

                        int index =
                                SystemAlgorithms.binarySearchClubByName(clubs, name);

                        if (index != -1)
                            System.out.println(clubs[index]);
                        else
                            System.out.println("Club Not Found");

                    } else {
                        System.out.println("Add Clubs First");
                    }

                    break;


                // Search Member
                case 5:

                    if (membersAdded) {

                        System.out.print("Enter Member ID: ");
                        int id = scanner.nextInt();

                        int index =
                                SystemAlgorithms.binarySearchMemberById(members, id);

                        if (index != -1)
                            System.out.println(members[index]);
                        else
                            System.out.println("Member Not Found");

                    } else {
                        System.out.println("Add Members First");
                    }

                    break;


                // Show Clubs
              case 6:

    if (clubsAdded) {

        System.out.println("\n--- Clubs Sorted ---");

        for (Club c : clubs)
            System.out.println(c);
    }

    break;

                // Show Members
                case 7:

    if (membersAdded) {

        System.out.println("\n--- Members Sorted ---");

        for (Member m : members)
            System.out.println(m);
    }

    break;
                // Show Sports
                case 8:

    if (sportsAdded) {

        System.out.println("\n--- Sports Sorted ---");

        for (Sport s : sports)
            System.out.println(s);
    }

    break;
    
    
    //exit
                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 0);

        scanner.close();
    }
}