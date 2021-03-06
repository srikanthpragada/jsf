package jsfdemo;

import javax.faces.bean.ManagedBean;
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

@ManagedBean 
public class JobsBean {
	
	public RowSet  getJobs() {
		try {
			CachedRowSet crs = new OracleCachedRowSet();
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setCommand("select * from jobs");
			crs.execute();
			return crs;
		} catch (Exception ex) {
			return null;
		}
	}
	
	public List<Job>  getAllJobs() {
		try {
			CachedRowSet crs = new OracleCachedRowSet();
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setCommand("select * from jobs");
			crs.execute();
			ArrayList<Job> jobs  = new ArrayList<>();
			while(crs.next()) {
				Job j = new Job();
				j.setId( crs.getString("job_id"));
				j.setTitle( crs.getString("job_title"));
				jobs.add(j);
			}
			crs.close();
			return jobs;
		} catch (Exception ex) {
			return null;
		}
	}

}
