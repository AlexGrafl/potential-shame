package at.sks.bookservice.exceptions;


import javax.ejb.ApplicationException;

/**
 * @author Alex
 */
@ApplicationException(rollback = true)
public class BookServiceException extends RuntimeException{

}
