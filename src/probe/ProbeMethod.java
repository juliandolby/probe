package probe;
/** A represenatation of a method. */
public class ProbeMethod {

    /** The object representing the declaring class of the method. */
    public ProbeClass cls() { return cls; }
    /** The name of the method. */
    public String name() { return name; }
    /** The arguments to the method, in the same format as in Java bytecode. */
    public String signature() { return signature; }
    /** Is this method application, as opposed to library */
    public boolean isApplication() { return isApplication; }
    public int hashCode() {
        if (cls == null)
        	return name.hashCode() + signature.hashCode();
        else
        	return cls.hashCode() + name.hashCode() + signature.hashCode();
    }
    public boolean equals( Object o ) {
        if( !(o instanceof ProbeMethod) ) return false;
        ProbeMethod other = (ProbeMethod) o;
        //if( !cls.equals(other.cls) ) return false;
        if( !name.equals(other.name) ) return false;
        if( !signature.equals(other.signature) ) return false;
        return true;
    }
    public String toString() {
    	if (cls == null)
    		return name + "(" + signature + ")";
    	else
    		return cls.toString()+": "+name+"("+signature+")";
    }
    

    /* End of public methods. */
    
    public ProbeMethod(String name, String signature, boolean isApplication) {
    	this.name = name;
    	this.signature = signature;
    	this.isApplication = isApplication;
    }
    
    public ProbeMethod( ProbeClass cls, String name, String signature, boolean isApplication ) {
        //if( cls == null ) throw new NullPointerException();
        if( name == null ) throw new NullPointerException();
        if( signature == null ) throw new NullPointerException();
        this.cls = cls;
        this.name = name;
        this.signature = signature;
        this.isApplication = isApplication;
    }

    /* End of package methods. */

    private ProbeClass cls;
    private String name;
    private String signature;
    private boolean isApplication;
}
