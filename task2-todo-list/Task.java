
public class Task {
    private String title;
    private String description;
    private String status;
    public Task(String title, String description){
        this.title = title;
        this.description = description;
        this.status = "Pending";
    }

    public String getTitle(){
        return title;
    }

    public void setStatus(String newStatus){
        this.status = newStatus;
    }

    public String toString(){
        return (title +" : "+ description + "[ "+ status + " ]");
    }
    
}
