package com.example.demo.model;


@Entity
public class PersonProfile{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
}