package com.cydeo.service;



import com.cydeo.model.*;

import java.util.ArrayList;
import java.util.List;


    public class DataGenerator {

        /**
         * Roles dummy data.
         * @return list of roles created. {@link List<Role>}
         */
        public static List<Role> fillRoles() {
            List<Role> roles = new ArrayList<>();
            roles.add(Role.builder().id(1).name("STUDENT").build());
            roles.add(Role.builder().id(2).name("MANAGER").build());
            roles.add(Role.builder().id(3).name("ADMIN").build());
            return roles;
        }

        /**
         * Find Role by id.
         * @param id id as parameter {@link Integer}
         * @return founded role. {@link Role}
         */
        public static Role findRoleById(Integer id) {
            return fillRoles().stream()
                    .filter(role -> role.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        }


        /**
         * Users dummy data.
         * @return list of users created. {@link List<User>}
         */
        public static List<User> fillUsers() {
            List<User> users = new ArrayList<>();
            users.add(new User(1, "John", "Doe", "john@email.com", findRoleById(3), UserState.CONFIRMED));
            users.add(new User(2, "Ava", "Hill", "ava@email.com", findRoleById(2), UserState.CONFIRMED));
            users.add(new User(3, "Kelly", "Baker", "kelly@email.com", findRoleById(2), UserState.CONFIRMED));
            users.add(new User(4, "Paul", "Jenkins", "paul@email.com", findRoleById(1), UserState.PENDING));
            users.add(new User(5, "Seth", "Jones", "seth@email.com", findRoleById(1), UserState.SUSPENDED));
            users.add(new User(6, "Era", "Myer", "era@email.com", findRoleById(1), UserState.CONFIRMED));
            users.add(new User(7, "Jale", "Thomas", "jale@email.com", findRoleById(1), UserState.SUSPENDED));
            users.add(new User(8, "Fatos", "Bryant", "fatos@email.com", findRoleById(1), UserState.CONFIRMED));
            users.add(new User(9, "Ellie", "Perez", "ellie@email.com", findRoleById(1), UserState.CONFIRMED));
            users.add(new User(10, "Meg", "Smith", "meg@email.com", findRoleById(1), UserState.SUSPENDED));
            users.add(new User(11, "Steven", "Walker", "steven@email.com", findRoleById(1), UserState.CONFIRMED));
            return users;
        }

        /**
         * Find User by id.
         * @param id id as parameter {@link Integer}
         * @return founded user. {@link User}
         */
        public static User findUserById(Integer id) {
            return fillUsers().stream()
                    .filter(user -> user.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        }

        /**
         * Courses dummy data.
         * @return list of courses.
         */
        public static List<Course> fillCourses() {
            List<Course> courses = new ArrayList<>();
            courses.add(new Course(1, "Java fundamentals", 1481));
            courses.add(new Course(2, "Java Become a web developer", 1697));
            courses.add(new Course(3, "Java Beginner to Masterclass", 2183));
            courses.add(new Course(4, "Java Become a Tester", 800));
            courses.add(new Course(5, "Algorithm and data structures", 760));
            courses.add(new Course(6, "Full Stack developer spring boot + angular", 1760));
            courses.add(new Course(7, "Become a javascript developer", 1030));
            return courses;
        }

        /**
         * Find Course by id.
         * @param id id as parameter {@link Integer}
         * @return founded course. {@link Course}
         */
        public static Course findCourseById(Integer id) {
            return fillCourses().stream()
                    .filter(course -> course.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        }

        /**
         * This is a static method to get all CourseAssigned
         * object.
         * @return all CourseAssigned {@link CourseAssigned}
         */
        public static List<CourseAssigned> fillCoursesAssigned() {
            List<CourseAssigned> courseAssigners = new ArrayList<>();
            courseAssigners.add(new CourseAssigned(findCourseById(1), findUserById(6), CourseStatus.FINISHED));
            courseAssigners.add(new CourseAssigned(findCourseById(3), findUserById(6), CourseStatus.FINISHED));
            courseAssigners.add(new CourseAssigned(findCourseById(5), findUserById(6), CourseStatus.IN_PROGRESS));
            courseAssigners.add(new CourseAssigned(findCourseById(7), findUserById(6), CourseStatus.NOT_STARTED));

            courseAssigners.add(new CourseAssigned(findCourseById(5), findUserById(5), CourseStatus.FINISHED));
            courseAssigners.add(new CourseAssigned(findCourseById(2), findUserById(5), CourseStatus.IN_PROGRESS));

            courseAssigners.add(new CourseAssigned(findCourseById(2), findUserById(9), CourseStatus.FINISHED));
            courseAssigners.add(new CourseAssigned(findCourseById(4), findUserById(9), CourseStatus.FINISHED));
            courseAssigners.add(new CourseAssigned(findCourseById(6), findUserById(9), CourseStatus.NOT_STARTED));

            courseAssigners.add(new CourseAssigned(findCourseById(7), findUserById(7), CourseStatus.IN_PROGRESS));

            courseAssigners.add(new CourseAssigned(findCourseById(5), findUserById(8), CourseStatus.FINISHED));
            courseAssigners.add(new CourseAssigned(findCourseById(6), findUserById(8), CourseStatus.FINISHED));

            courseAssigners.add(new CourseAssigned(findCourseById(2), findUserById(11), CourseStatus.FINISHED));
            courseAssigners.add(new CourseAssigned(findCourseById(7), findUserById(11), CourseStatus.FINISHED));
            courseAssigners.add(new CourseAssigned(findCourseById(6), findUserById(11), CourseStatus.IN_PROGRESS));

            courseAssigners.add(new CourseAssigned(findCourseById(1), findUserById(10), CourseStatus.NOT_STARTED));

            courseAssigners.add(new CourseAssigned(findCourseById(1), findUserById(2), CourseStatus.FINISHED));
            courseAssigners.add(new CourseAssigned(findCourseById(2), findUserById(2), CourseStatus.FINISHED));
            courseAssigners.add(new CourseAssigned(findCourseById(3), findUserById(2), CourseStatus.FINISHED));
            courseAssigners.add(new CourseAssigned(findCourseById(4), findUserById(2), CourseStatus.FINISHED));
            courseAssigners.add(new CourseAssigned(findCourseById(5), findUserById(2), CourseStatus.FINISHED));
            courseAssigners.add(new CourseAssigned(findCourseById(6), findUserById(2), CourseStatus.FINISHED));
            courseAssigners.add(new CourseAssigned(findCourseById(7), findUserById(2), CourseStatus.FINISHED));

            return courseAssigners;
        }
    }

