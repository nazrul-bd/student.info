package com.student.main.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "error")
public class ErrorResponse  {
    private String message;
    private List<String> details;
}

