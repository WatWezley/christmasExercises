package xmasExercise.MBTI;



import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

import static java.awt.Color.blue;
import static java.awt.Color.green;

public class MyersBriggsPersonality {

    Scanner scanner = new Scanner(System.in);


    private String name;

    String personality;


    int counter = 0;

    int answerList = 0;

    int row = 0;
    int E = 0;
    int I = 0;
    int S = 0;
    int N = 0;
    int T = 0;
    int F = 0;
    int J = 0;
    int P = 0;


    String[][] myersBriggsQuestions = new String[20][2];

    String[][] myersBriggsAnswer = new String[7][12];

    String[] extrovertIntrovert = new String[5];
    String[] sensingIntuitive = new String[5];
    String[] thinkingFeeling = new String[5];
    String[] judgingPerceptive = new String[5];


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public String[][] fillMyersBriggsQuestionnaire() {
        myersBriggsQuestions[0][0] = "1A: Expend energy, enjoy groups.";
        myersBriggsQuestions[0][1] = "1B: Conserve energy, enjoy one on one.";
        myersBriggsQuestions[1][0] = "2A: Interpret literally.";
        myersBriggsQuestions[1][1] = "2B: Look for meaning and possibility";
        myersBriggsQuestions[2][0] = "3A: Logical,thinking,questioning.";
        myersBriggsQuestions[2][1] = "3B: Empathetic,feeling,accommodating.";
        myersBriggsQuestions[3][0] = "4A: Organized,orderly.";
        myersBriggsQuestions[3][1] = "4B: Flexible,adaptable.";
        myersBriggsQuestions[4][0] = "5A: More outgoing, thinking out loud.";
        myersBriggsQuestions[4][1] = "5B: More Reserved, think to yourself.";
        myersBriggsQuestions[5][0] = "6A: Practical, realistic,experimental.";
        myersBriggsQuestions[5][1] = "6B: Imaginative,innovative,theoretical.";
        myersBriggsQuestions[6][0] = "7A: Candid,straight forward,frank.";
        myersBriggsQuestions[6][1] = "7B: Tactful,kind,encouraging";
        myersBriggsQuestions[7][0] = "8A: Plan,Schedule.";
        myersBriggsQuestions[7][1] = "8B: Unplanned Spontaneous";
        myersBriggsQuestions[8][0] = "9A: Seek many tasks, public activities, interaction with others.";
        myersBriggsQuestions[8][1] = "9B: Seek private, solitary activities with quiet to concentration.";
        myersBriggsQuestions[9][0] = "10A: Standard, usual, conventional.";
        myersBriggsQuestions[9][1] = "10B: Different, novel,unique.";
        myersBriggsQuestions[10][0] = "11A: Firm,tend to criticize,hold the line.";
        myersBriggsQuestions[10][1] = "11B: gentle, tend to appreciate, conciliate.";
        myersBriggsQuestions[11][0] = "12A: Regulated, structured.";
        myersBriggsQuestions[11][1] = "12B: Easygoing, live and let live.";
        myersBriggsQuestions[12][0] = "13A: External, communicative, express yourself.";
        myersBriggsQuestions[12][1] = "13B: Internal,reticent,keep to yourself.";
        myersBriggsQuestions[13][0] = "14A: Focus on here and now.";
        myersBriggsQuestions[13][1] = "14B: Looking to the future,global perspective,big picture.";
        myersBriggsQuestions[14][0] = "15A: Tough-Minded, just.";
        myersBriggsQuestions[14][1] = "15B: Tender-hearted, merciful";
        myersBriggsQuestions[15][0] = "16A: Preparation, plan ahead.";
        myersBriggsQuestions[15][1] = "16B. Go with the flow, adapt as you go.";
        myersBriggsQuestions[16][0] = "17A: Active, initiate.";
        myersBriggsQuestions[16][1] = "17B:  Reflective,deliberate.";
        myersBriggsQuestions[17][0] = "18A: Facts, things, 'what is'.";
        myersBriggsQuestions[17][1] = "18B: Ideas,dreams,'what could',philosophical.";
        myersBriggsQuestions[18][0] = "19A: Matter of facts,issue oriented.";
        myersBriggsQuestions[18][1] = "19B: Sensitive, People Oriented, compassionate.";
        myersBriggsQuestions[19][0] = "20A: Control, govern.";
        myersBriggsQuestions[19][1] = "20B: Latitude,freedom.";
        return myersBriggsQuestions;
    }


    public void fillMyersBriggsAnswers() {
        for (String[] row : myersBriggsAnswer) {
            Arrays.fill(row, " ");
        }

    }

    public void setMyersBriggsAnswer() {
        String response;
        for (counter = 0; counter < myersBriggsQuestions.length; counter++) {
            do {
                System.out.println("Which of this Options describes you: A or B.");
                for (int i = 0; i <= 0; i++) {
                    System.out.println(fillMyersBriggsQuestionnaire()[counter][0]);
                }
                for (int j = 1; j <= 1; j++) {
                    System.out.println(myersBriggsQuestions[counter][1]);
                }
                String answer = scanner.nextLine();
                response = answer.toUpperCase();
            }
            while (!response.equalsIgnoreCase("A") && !response.equalsIgnoreCase("B"));
            setMyersBriggsAnswerTable(response);
            categorisingAnswer(response, counter);

        }

    }

    public void setMyersBriggsAnswerTable(String response) {
        row = counter / 4;
        int column = answerList % 12;
        myersBriggsAnswer[row][column] = String.valueOf(counter + 1);
        if (response.equalsIgnoreCase("A")) {
            myersBriggsAnswer[row][column + 1] = response.toUpperCase();
        } else if (response.equalsIgnoreCase("B")) {
            myersBriggsAnswer[row][column + 2] = response.toUpperCase();
        }
        answerList += 3;
        myersBriggsAnswer[5][0] = "Total";
        myersBriggsAnswer[6][1] = "E";
        myersBriggsAnswer[6][2] = "I";
        myersBriggsAnswer[6][4] = "S";
        myersBriggsAnswer[6][5] = "N";
        myersBriggsAnswer[6][7] = "T";
        myersBriggsAnswer[6][8] = "F";
        myersBriggsAnswer[6][10] = "J";
        myersBriggsAnswer[6][11] = "P";


    }

    public void categorisingAnswer(String response, int counter) {
        int category = counter % 4;
        switch (category) {
            case 0:
                switch (response) {
                    case ("A") -> {
                        E++;
                        extrovertIntrovert[row] = myersBriggsQuestions[counter][0];
                    }
                    case ("B") -> {
                        I++;
                        extrovertIntrovert[row] = myersBriggsQuestions[counter][1];
                    }
                }
                break;

            case 1:
                switch (response) {
                    case ("A") -> {
                        S++;
                        sensingIntuitive[row] = myersBriggsQuestions[counter][0];
                    }
                    case ("B") -> {
                        N++;
                        sensingIntuitive[row] = myersBriggsQuestions[counter][1];
                    }
                }
                break;

            case 2:
                switch (response) {
                    case ("A") -> {
                        T++;
                        thinkingFeeling[row] = myersBriggsQuestions[counter][0];
                    }
                    case ("B") -> {
                        F++;
                        thinkingFeeling[row] = myersBriggsQuestions[counter][1];
                    }
                }
                break;
            case 3:
                switch (response) {
                    case ("A") -> {
                        J++;
                        judgingPerceptive[row] = myersBriggsQuestions[counter][0];
                    }
                    case ("B") -> {
                        P++;
                        judgingPerceptive[row] = myersBriggsQuestions[counter][1];
                    }
                }
        }
    }

    public void compilingResult() {
        String output1;
        String output2;
        String output3;
        String output4;
        if (E > I) {
            myersBriggsAnswer[5][1] = String.valueOf(E);
            output1 = "E";
        } else {
            myersBriggsAnswer[5][2] = String.valueOf(I);
            output1 = "I";
        }
        if (S > N) {
            myersBriggsAnswer[5][4] = String.valueOf(S);
            output2 = "S";
        } else {
            myersBriggsAnswer[5][5] = String.valueOf(N);
            output2 = "N";
        }
        if (T > F) {
            myersBriggsAnswer[5][7] = String.valueOf(T);
            output3 = "T";
        } else {
            myersBriggsAnswer[5][8] = String.valueOf(F);
            output3 = "F";
        }
        if (S > N) {
            myersBriggsAnswer[5][10] = String.valueOf(J);
            output4 = "J";
        } else {
            myersBriggsAnswer[5][11] = String.valueOf(P);
            output4 = "P";
        }

        personality = output1 + output2 + output3 + output4 + "";
        PersonalitiesType type = PersonalitiesType.valueOf(personality);

    }


    public void getPersonality() {
        System.out.println("Extrovert or Introvert");
        for (String item : extrovertIntrovert) {
            System.out.println(Arrays.toString(new String[]{item})
                    .replace("[", " ").replace("]", " "));
        }
        System.out.println("The number of Extrovert choices are: " + E);
        System.out.println("The number of Introvert choices are: " + I);
        System.out.println();
        System.out.println("Sensing or Intuitive");
        for (String s : sensingIntuitive) {
            System.out.println(Arrays.toString(new String[]{s})
                    .replace("[", " ").replace("]", " "));
        }
        System.out.println("The number of Sensing choices are: " + S);
        System.out.println("The number of Intuitive choices are: " + N);
        System.out.println();
        System.out.println("Thinking or Feeling");
        for (String value : thinkingFeeling) {
            System.out.println(Arrays.toString(new String[]{value})
                    .replace("[", " ").replace("]", " "));
        }
        System.out.println("The number of Thinking choices are: " + T);
        System.out.println("The number of Feeling choices are: " + F);
        System.out.println();
        System.out.println("judging or Perceptive");
        for (String s : judgingPerceptive) {
            System.out.println(Arrays.toString(new String[]{s})
                    .replace("[", " ").replace("]", " "));
        }
        System.out.println("The number of Judging choices are: " + J);
        System.out.println("The number of Perceptive choices are: " + P);
        System.out.println();

        System.out.println(personality);
    }

    public void tablePresentation() {
        String[] heading = {"", "A", "B", "", "A", "B", "", "A", "B", "", "A", "B"};
        JTable table = new JTable(myersBriggsAnswer, heading);
        Font font = new Font("Verdana", Font.PLAIN, 12);
        table.setFont(font);
        table.setRowHeight(30);
        table.setGridColor(blue);
        JFrame frame = new JFrame();
        frame.setSize(600, 400);
        frame.add(new JScrollPane(table));
        frame.setVisible(true);
        frame.setBackground(green);
        table.getColumnModel().getColumn(0).setCellRenderer(
                new DefaultTableCellRenderer() {
                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                                   boolean hasFocus, int row, int column) {
                        setText(value.toString());
                        setBackground(isSelected ? Color.blue : Color.gray);
                        return this;
                    }

                    ;
                });
        table.getColumnModel().getColumn(3).setCellRenderer(
                new DefaultTableCellRenderer() {
                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                                   boolean hasFocus, int row, int column) {
                        setText(value.toString());
                        setBackground(isSelected ? Color.blue : Color.gray);
                        return this;
                    }

                    ;
                });
        table.getColumnModel().getColumn(6).setCellRenderer(
                new DefaultTableCellRenderer() {
                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                                   boolean hasFocus, int row, int column) {
                        setText(value.toString());
                        setBackground(isSelected ? Color.blue : Color.gray);
                        return this;
                    }

                    ;
                });
        table.getColumnModel().getColumn(9).setCellRenderer(
                new DefaultTableCellRenderer() {
                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                                   boolean hasFocus, int row, int column) {
                        setText(value.toString());
                        setBackground(isSelected ? Color.blue : Color.gray);
                        return this;
                    }

                    ;
                });
    }


    public void personalityNarration(PersonalitiesType type) {
        switch (type) {
            case ISTJ -> {
                System.out.println("""
                        The Inspector (ISTJ Personality)
                        ISTJs are serious, proper, and formal in appearance which can be intimidating. They are cultured and have an affection towards tradition. In contrast, they are quiet and usually calm.  They are called inspectors because of their keen attention to detail. ISTJ are rule followers who always take the logical approach towards their goals and projects.
                                                
                        Their dominant cognitive function is introverted sensing which helps them take in the details about their environment while their auxiliary cognitive function is extraverted thinking which makes them efficient and logical thinkers.
                                                
                        In their relationships, they are very loyal to their friends and family members. Usually, they have a small circle with who they prefer spending their time with. The ISTJ thrives in jobs that require structure, logic, and stability.
                                                
                                                
                        """);
                break;
            }
            case INFJ -> {
                System.out.println("""
                        The Counselor (INFJ Personality)
                        INFJs are visionaries who have a different view of the world. They love introspection and refuse to take things at a surface level. They could be termed weird by others because of how they see life. The INFJ are idealists who love understanding complex issues. They are reserved leaders who are usually creatives due to how easily they get inspired.
                                                        
                        Also known as the diplomats, the INFJ prefers to cooperate with members of their team as opposed to conflict.
                                                        
                        The dominant cognitive function of an INFJ is introverted intuition which helps them focus on internal insights and generally influences their decision making. Their tertiary cognitive function is an extraverted feeling which makes them highly sensitive to the feeling of others or what others refer to as being empathetic.\s
                                                        
                        The INFJ thrives in jobs that require a deal of compassion, psychology and/or collaboration.
                        """);
                break;
            }
            case INTJ -> {
                System.out.println("""
                        The Mastermind (INTJ Personality)
                        INTJs are introverts who are comfortable being by themselves. They would avoid socializing as it drains their energy. They excel at developing plans and strategies. As analytical problem solvers, this personality type is strategic and innovative
                                
                        Their dominant cognitive function is Introverted intuition which they use to read between the lines and unravel patterns. The auxiliary function is extraverted thinking which makes them deliberate about solutions and highly organized.\s
                                
                        Also known as the architects, the INTJ thrives in jobs that require logical systems and innovative solutions. They usually prefer to work alone. In relationships, they are loyal and are great at encouraging their partners.\s""");
                break;
            }
            case ENFJ -> {
                System.out.println("""
                         The Giver (ENFJ)
                        ENFJs are individuals who are people-centered. They rely mostly on their intuition and feelings and tend to live through their imagination. They focus on abstracts and what could happen in the future.
                        They are highly empathetic not just to their close friends and family but people in general.\s
                                                     
                        The ENFJ generally loves feedback and they can be referred to as people pleasers.\s
                                                     
                        Their dominant cognitive function is an extraverted feeling that helps them be in tune with other people’s feelings. Their auxiliary functions are introverted intuition that makes them focus on the future as opposed to the present moment.
                                                     
                        They thrive in jobs where they can encourage others and push them to grow. This also includes humanitarian focused jobs. In relationships, they are supportive and always willing to understand their partners""");
                break;
            }
            case ISTP -> {
                System.out.println("""
                        The Craftsman (ISTP)
                        ISTPs are mysterious, rational, and highly logical bunch. They are spontaneous and unpredictable most times albeit oblivious to those around them because they are experts at hiding their true nature.
                                                    
                        Their dominant cognitive function is introverted thinking which makes them focus on the logical aspect of a situation. The ISTP’s auxiliary cognitive function is extraverted sensing which helps them focus on abstract things.\s
                                                    
                        They thrive in jobs that require technical expertise and physical activity. In relationships, they are calm lovers who prefer being handy around the house""");
                break;
            }
            case ESFJ -> {
                System.out.println("""
                        The Provider (ESFJ)
                        ESFJs are stereotypically known to be extroverts. They are cheerleaders and raise the spirits of those around them earning them popularity. Because of their nature, they are easily liked and people easily warm up to them.
                                                    
                        Their dominant cognitive function is extroverted feeling that makes them work and make decisions based on their gut feeling. The ESFJ’s auxiliary cognitive function is introverted sensing which helps them focus on the present instead of the future or other abstract details.
                                                    
                        They thrive in jobs that require processes and interpersonal skills. In relationships, they are the traditional partners who believe in structure and stability.""");

                break;
            }
            case INFP -> {
                System.out.println("""
                        The Idealist (INFP)
                        INFPs are usually reserved and introverted. They usually spend time all by themselves in quiet places. They love analyzing signs and symbols using them to draw inferences in explaining what is happening around them.
                                           
                        Their dominant cognitive function is introverted feeling which helps them with processing emotions internally. The INFP auxiliary cognitive function is the extraverted intuition that helps them focus on the big picture through imagination.
                                           
                        They thrive in jobs that require visions and aligns with their goals/ interests. In relationships take time to select their friends and they are quite big on comprise.\s\040""");

                break;
            }
            case ESFP -> {
                System.out.println("""
                        The Performer (ESFP)
                        ESFPs are mostly perceived to be entertainers. They enjoy being in the spotlight. They enjoy exploring and learning to share what they’ve learned with others through their strong interpersonal skills.
                                            
                        Their dominant cognitive function is extraverted sensing which helps them stick to facts instead of abstract ideas. The ESFP’s auxiliary cognitive function is introverted feeling which helps them make decisions.
                                            
                        They thrive in work environments where they can be spontaneous, move around often, and involves the use of artistic values. In relationships, the ESFP will prioritize their family and loved ones over anything although they can also strongly dislike a structured life.""");
                break;

            }
            case ENFP -> {
                System.out.println("""
                        The Champion (ENFP)
                        ENFPs are highly individualistic and refuse to live their lives inside a box. They strive to create their own methods of doing things. They operate with their feelings and are highly perceptive and thoughtful
                                            
                        "the-champion"
                                            
                        Their dominant cognitive function is extraverted intuition which allows them to focus on abstract thoughts and patterns. The auxiliary cognitive function is introverted feelings which make them focus on their feelings rather than logic.
                                            
                        In relationships, the ENFP is always expressive and share affection openly. They also thrive in jobs that demand creativity and imaginative solutions.""");

                break;
            }
            case ESTP -> {
                System.out.println("""
                        The Doer (ESTP)
                        ESTPs are governed by the need to interact with others. They are interested in abstracts and theories. They are spontaneous and risk-taking. They aren’t afraid of making mistakes as they make it up as they go along.
                                                
                        Their dominant cognitive function is extraverted sensing which makes them action-oriented. The auxiliary cognitive function of an ESTP is introverted thinking which makes them highly disciplined and very observant.
                                                
                        They thrive in career paths that require mechanical skills, flexibility, and one that is quite unpredictable. In relationships, they can be quite adventurous and prefer activities with their loved ones.""");

                break;
            }
            case ESTJ -> {
                System.out.println("""
                        The Supervisor (ESTJ)
                        ESTJs are organized and governed by the zeal to do what is right and socially acceptable. They epitomize the ideal individual who is on the track towards doing what is “good” and “right”. They are happy to be of help.
                                               
                        Their dominant cognitive function is extraverted thinking which makes them quite practical when compared to other personality types. The auxiliary cognitive functions are introverted sensing which makes them very keen on details and stability.
                                               
                        The ESTJ’s like to work in management positions where they can oversee operations and put in structures. In relationships, they love routines and their loved ones know that they can always be depended on for anything.\040""");

                break;
            }
            case ENTJ -> {
                System.out.println("""
                        The Commander (ENTJ)
                        ENTJs focus on dealing with all things rationally and logically. They are naturally born leaders who command respect. They also do enjoy being in charge. They see obstacles as challenges in which they can prove themselves.
                                                
                        Their dominant cognitive function is extraverted thinking which makes them deliberate about orders and judgments. The auxiliary function is introverted intuition which makes them trust their instincts during decision making.
                                                
                        The ENTJ thrives in jobs that are complex and require clear strategies for goals. In relationships, they can set high expectations for their loved ones and can be sometimes domineering.""");

                break;
            }
            case INTP -> {
                System.out.println("""
                        The Thinker (INTP)
                        INTPs are typically known for their brilliant ideas and propositions. They see a pattern in everything and can easily pick out something that’s out of place. They are concerned with finding an environment where their creative genius can be harnessed.
                                               
                        Their dominant cognitive functions is introverted thinking which makes them highly understanding and deep thinkers. The auxiliary functions are extraverted intuition which helps with their imagination and inspirations.
                                               
                        The INTP thrives in work environments that aren’t focused on traditions. They prefer flexible and independent work styles. In relationships, they are highly unconventional and autonomous.\040""");
                break;
            }
            case ISFJ -> {
                System.out.println("""
                        The Nurturer (ISFJ)
                        ISFJs are highly generous and ever-ready to give back to society. They are warm and kind-hearted individuals. They possess an awareness and consideration towards bringing out the best in others.
                                                
                        "the-nurturer"
                                                
                        The dominant cognitive function is introverted sensing which makes them very detail-oriented. Their auxiliary functions are extraverted feeling which makes them nurturing and very considerate.
                                                
                        They thrive in jobs that require structure and are positioned behind the scenes. In relationships, the ISFJ will take care of their loved ones unconditionally.""");
                break;
            }
            case ENTP -> {
                System.out.println("""
                        The Visionary (ENTP)
                        ENTPs are extroverts who do not enjoy small talk. These personalities are very rare to come across. They have a logical and rational approach to discussions and/or arguments. They are knowledgeable but need constant stimulation.
                                                
                        Their dominant cognitive function is extroverted intuition which makes them always open to exploring new ideas. The auxiliary function is introverted thinking which makes them quite logical.
                                                
                        They thrive in jobs where creativity meets challenges. In relationships, the ENTP is spontaneous and can be quite exciting.""");
                break;
            }
            case ISFP -> {
                System.out.println("""
                        The Composer (ISFP)
                        ISFPs on the outside seem like introverts but deep down they’re warm and very friendly. They are spontaneous and fun to be with. They are always out to explore new things and discover new experiences.
                                               
                        Their dominant cognitive function is introverted feeling which makes them caring. The auxiliary functions are extraverted sensing which makes them appreciate works of art.\s
                                               
                        ISFP’s prefer to work independently away from the spotlight. In relationships,  they are accommodating and very easygoing\040""");
            }
        }


        }


    public void compilingAnswer() {
        fillMyersBriggsQuestionnaire();
        fillMyersBriggsAnswers();
        setMyersBriggsAnswer();
    }

    public void displayResult() {
        System.out.println();
        System.out.println("Hello " + name + " you selected:");
        System.out.println();
        compilingResult();
        tablePresentation();
        getPersonality();
        System.out.println();
        personalityNarration(PersonalitiesType.valueOf(personality));
    }
}













