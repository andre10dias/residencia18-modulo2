package src;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatasDeNascimentos implements DadosEstatisticos {
	List<Date> datas;
	
	public DatasDeNascimentos() {
		this.datas = new ArrayList<Date>();
	}
	
	public List<Date> getData() {
		return datas;
	}

	public void addData(Date data) {
		this.datas.add(data);
	}

	public Object maximo() {
		Date max = datas.get(0); 
		for (int i = 0; i < datas.size(); i++) {
			if (datas.get(i).getYear() > max.getYear()) {
				max = datas.get(i);
			}else if (datas.get(i).getYear() == max.getYear()) {
				if (datas.get(i).getMonth() > max.getMonth()) {
					max = datas.get(i);
				}else if (datas.get(i).getMonth() == max.getMonth()) {
					if (datas.get(i).getDay() > max.getDay()) {
						max = datas.get(i);
					}
				}
			}
		}
		return max;
	}
	public Object minimo() {
		Date min = datas.get(0);
		for (int i = 0; i < datas.size(); i++) {
			if (datas.get(i).getYear() < min.getYear()) {
				min = datas.get(i);
			}else if (datas.get(i).getYear() == min.getYear()) {
				if (datas.get(i).getMonth() < min.getMonth()) {
					min = datas.get(i);
				}else if (datas.get(i).getMonth() == min.getMonth()) {
					if (datas.get(i).getDay() < min.getDay()) {
						min = datas.get(i);
					}
				}
			}
		}
		return min;
	}
	public void ordenar() {
		this.datas.sort((d1, d2) -> d1.compareTo(d2));
	}
	public Object buscar() {
		return null;
	}
	
	@Override
	public String toString() {
		return "DatasDeNascimentos = " + datas;
	}
	
	public static void main(String[] args) {
		DatasDeNascimentos d = new DatasDeNascimentos();
		d.addData(new Date());
		System.out.println(d.toString());
	}
	
	
}
