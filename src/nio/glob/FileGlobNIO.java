package nio.glob;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;


/**
 * 使用了Glob模式来搜索指定的目录及其子目录
 * @author zhangwenchao
 *
 */
public class FileGlobNIO {
	
	public static void main(String[] args) throws Exception {
		
		String glob = "glob:**/*.zip";
		String location = "D:/";
		match(glob,location);
	}

	private static void match(String glob, String location) throws Exception {
		System.getProperty("user.dir");
		final PathMatcher pathMatcher =   FileSystems.getDefault().getPathMatcher(glob);
		Files.walkFileTree(Paths.get(location), new SimpleFileVisitor<Path>(){

			@Override
			public FileVisitResult visitFile(Path path,
					BasicFileAttributes attrs) throws IOException {
				if (pathMatcher.matches(path)) {
                    System.out.println(path);
                }
                return FileVisitResult.CONTINUE;

			}

			@Override
			public FileVisitResult visitFileFailed(Path file, IOException exc)
					throws IOException {
				
				return FileVisitResult.CONTINUE;
			}
			
		});
	}
	

}
