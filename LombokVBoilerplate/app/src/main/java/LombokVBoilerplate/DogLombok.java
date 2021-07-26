package LombokVBoilerplate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Lombok is a library that helps reduce boilerplate code in java projects
 * The next description were taken from the Lombok features page...
 * 
 * Data
 *  All together now: A shortcut for @ToString, @EqualsAndHashCode,
 *  Getter on all fields, and @Setter on all non-final fields,
 *  and @RequiredArgsConstructor! 
 * 
 * NoArgsConstructor, RequiredArgsConstructor and AllArgsConstructor
 *  Constructors made to order: Generates constructors that take no arguments,
 *  one argument per final / non-null field, or one argument for every field.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DogLombok {
    private String name;
    private String breed;
    private int age;
    private String color;
}