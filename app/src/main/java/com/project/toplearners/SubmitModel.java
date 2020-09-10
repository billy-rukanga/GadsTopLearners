package com.project.toplearners;

public class SubmitModel {

        private String email;
        private String firstName;
        private String lastName;
        private String link;

        public SubmitModel(String email, String firstName, String lastName, String link) {
            this.email = email;
            this.firstName = firstName;
            this.lastName = lastName;
            this.link = link;
        }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLink() {
        return link;
    }
}
