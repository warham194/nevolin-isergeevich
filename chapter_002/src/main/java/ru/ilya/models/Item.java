package ru.ilya.models;

public class Item {
	private String id;
  public String name;
  public String description;
  public long create;
  public Item() {
  }
  public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;

  }

    @Override
    public String toString() {
        return "Item{"
                +
                "id='" + id + '\''
                +
                ", name='" + name + '\''
                +
                ", description='" + description + '\''
                +
                ", create=" + create
                +
                '}';
    }

    public String getName() {
      return this.name;
    }

     public String getDescription() {
      return this.description;
    }

    public long getCreate() {
      return this.create;
     }

     public long setCreate(long create) { return  this.create;}
     public String getId() {
      return this.id;
     }

     public void setId(String id) {
         this.id = id;
     }


    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }
}