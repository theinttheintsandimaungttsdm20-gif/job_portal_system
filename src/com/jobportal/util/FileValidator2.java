package com.jobportal.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.jobportal.model.ApplicationModel;
import com.jobportal.model.FileBucket;

@Component
public class FileValidator2 implements Validator {
		
	public boolean supports(Class<?> clazz) {
		return ApplicationModel.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		ApplicationModel file = (ApplicationModel) obj;
			
		if(file.getFile()!=null){
			if (file.getFile().getSize() == 0) {
				errors.rejectValue("file", "missing.file");
			}
		}
	}
}

