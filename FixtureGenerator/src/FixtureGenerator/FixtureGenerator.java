package FixtureGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class FixtureGenerator {
    ArrayList<String> teams;
    ArrayList<String> matches;


    public void run(){
        Scanner input = new Scanner(System.in);
        System.out.println("Press 0 if you input team enough.");
        ArrayList<String> teams1 = new ArrayList<>();
        ArrayList<String> matches1 = new ArrayList<>();

        while (true){
            System.out.print("Enter the team : ");
            String teamName = input.next();
            if(Objects.equals(teamName, "0")){
                break;
            }
            else{
                teams1.add(teamName);
            }
        }
        if(teams1.size()%2==1){
            teams1.add("Bay");
        }

        setTeams(teams1);
        System.out.println(getTeams());


        for(int i= 0; i<getTeams().size() ; i++){
            for(int j = 0 ; j<getTeams().size(); j++){

                if(i!=j){
                    String str = getTeams().get(i)+" vs "+getTeams().get(j);
                    matches1.add(str);
                }
            }
        }
        setMatches(matches1);
        int totalMatch = getTeams().size()*(getTeams().size()-1);
        int totalWeek = totalMatch/(getTeams().size()/2);

        int j = getMatches().size();
        int a = 0;
        int swift= 1;

        int week = 1;
        for (int k=0; k<totalWeek ; k++,week++){
            System.out.println("\nWeek "+week+" -----------");
            for (int i=0; i<getTeams().size()/2 ; i++,j--,a++,swift++){
                if(swift%2==1){
                    System.out.println(getMatches().get(a));
                }else{
                    System.out.println(getMatches().get(j));
                }
            }
        }
    }

    public ArrayList<String> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<String> teams) {
        this.teams = teams;
    }

    public ArrayList<String> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<String> matches) {
        this.matches = matches;
    }
}
